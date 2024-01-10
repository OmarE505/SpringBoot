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
        BDDMockito.given(vendorRepository.findAll())
                .willReturn(Flux.just(Vendor.builder().firstName("Omar").lastName("Emad").build(), Vendor.builder().firstName("Omar1").lastName("Emad").build()));

        webTestClient.get()
                .uri("/api/v1/vendors")
                .exchange()
                .expectBodyList(Vendor.class)
                .hasSize(2);
    }

    @Test
    public void getVendorById() {
        BDDMockito.given(vendorRepository.findById("someid"))
                .willReturn(Mono.just(Vendor.builder().firstName("Omar").lastName("Emad").build()));
        webTestClient.get()
                .uri("api/v1/vendors/someid")
                .exchange()
                .expectBody(Vendor.class);
    }

    @Test
    public void testCreateVendor() {
        BDDMockito.given(vendorRepository.saveAll(any(Publisher.class)))
                .willReturn(Flux.just(Vendor.builder().firstName("Omar").lastName("Emad").build()));

        Mono<Vendor> catToSaveMono = Mono.just(Vendor.builder().firstName("Omar").lastName("Emad2").build());

        webTestClient.post()
                .uri("/api/v1/vendors")
                .body(catToSaveMono, Vendor.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }
}