package com.omare505.spring5webfluxrest.controllers;

import com.omare505.spring5webfluxrest.domain.Category;
import com.omare505.spring5webfluxrest.domain.Vendor;
import com.omare505.spring5webfluxrest.repositories.VendorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class VendorControllerTest {

    WebTestClient webTestClient;
    VendorRepository vendorRepository;
    VendorController vendorController;

    @BeforeEach
    public void setUp() throws Exception {
        vendorRepository = Mockito.mock(VendorRepository.class);
        vendorController = new VendorController(vendorRepository);
        webTestClient = WebTestClient.bindToController(vendorController).build();
    }

    @Test
    public void getAllVendors() {
        given(vendorRepository.findAll())
                .willReturn(Flux.just(Vendor.builder().firstName("Omar").lastName("Emad").build(), Vendor.builder().firstName("Omar1").lastName("Emad").build()));

        webTestClient.get()
                .uri("/api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getVendorById() {
        given(vendorRepository.findById("someid"))
                .willReturn(Mono.just(Vendor.builder().firstName("Omar").lastName("Emad").build()));
        webTestClient.get()
                .uri("api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);
    }

    @Test
    public void testCreateVendor() {
        given(vendorRepository.saveAll(any(Publisher.class)))
                .willReturn(Flux.just(Vendor.builder().firstName("Omar").lastName("Emad").build()));

        Mono<Vendor> vendorToSave = Mono.just(Vendor.builder().firstName("Omar").lastName("Emad2").build());

        webTestClient.post()
                .uri("/api/v1/vendors")
                .body(vendorToSave, Vendor.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    public void TestUpdate() {
        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorToUpdate = Mono.just(Vendor.builder().firstName("Omar").lastName("Emad").build());

        webTestClient.put()
                .uri("/api/v1/vendors/asdfasdf")
                .body(vendorToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void testPatchVendorWithChanges() {

        given(vendorRepository.findById(anyString()))
                .willReturn(Mono.just(Vendor.builder().firstName("Jimmy").build()));

        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorMonoToUpdate = Mono.just(Vendor.builder().firstName("Jim").build());

        webTestClient.patch()
                .uri("/api/v1/vendors/someid")
                .body(vendorMonoToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(vendorRepository).save(any());
    }

    @Test
    public void testPatchVendorWithoutChanges() {

        given(vendorRepository.findById(anyString()))
                .willReturn(Mono.just(Vendor.builder().firstName("Jimmy").build()));

        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(Mono.just(Vendor.builder().build()));

        Mono<Vendor> vendorMonoToUpdate = Mono.just(Vendor.builder().firstName("Jimmy").build());

        webTestClient.patch()
                .uri("/api/v1/vendors/someid")
                .body(vendorMonoToUpdate, Vendor.class)
                .exchange()
                .expectStatus()
                .isOk();

        verify(vendorRepository, never()).save(any());
    }
}