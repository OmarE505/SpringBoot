package com.omare505.spring5webfluxrest.controllers;

import com.omare505.spring5webfluxrest.domain.Vendor;
import com.omare505.spring5webfluxrest.repositories.VendorRepository;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VendorController {
    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GetMapping("/api/v1/vendors")
    public Flux<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    @GetMapping("/api/v1/vendors/{id}")
    public Mono<Vendor> getVendorById(@PathVariable String id){
        return vendorRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/vendors")
    public Mono<Void> createVendor(@RequestBody Publisher<Vendor> vendorStream){
        return vendorRepository.saveAll(vendorStream).then();
    }

    @PutMapping("/api/v1/vendors/{id}")
    public Mono<Vendor> updateVendor(@PathVariable String id, @RequestBody Vendor vendor){
        vendor.setId(id);
        return vendorRepository.save(vendor);
    }

    @PatchMapping("/api/v1/vendors/{id}")
    public Mono<Vendor> patchVendor(@PathVariable String id, @RequestBody Vendor vendor){
        Vendor foundVendor = vendorRepository.findById(id).block();

        if(!foundVendor.getFirstName().equals(vendor.getFirstName())){
            foundVendor.setFirstName(vendor.getFirstName());
            return vendorRepository.save(foundVendor);
        }

        return Mono.just(foundVendor);
    }
}
