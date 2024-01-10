package com.omare505.spring5webfluxrest.bootstrap;

import com.omare505.spring5webfluxrest.domain.Category;
import com.omare505.spring5webfluxrest.domain.Vendor;
import com.omare505.spring5webfluxrest.repositories.CategoryRepository;
import com.omare505.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final VendorRepository vendorRepository;
    private final CategoryRepository categoryRepository;

    public Bootstrap(VendorRepository vendorRepository, CategoryRepository categoryRepository) {
        this.vendorRepository = vendorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(categoryRepository.count().block() == 0){
            //load data
            System.out.println("### LOAD DATA ON STARTUP ###");

            categoryRepository.save(Category.builder()
                            .description("Fruits")
                            .build()).block();
            categoryRepository.save(Category.builder()
                            .description("Vegetables")
                            .build()).block();
            categoryRepository.save(Category.builder()
                            .description("Nuts")
                            .build()).block();
            categoryRepository.save(Category.builder()
                            .description("Breads")
                            .build()).block();

            System.out.println("Loaded categories: " + categoryRepository.count().block());

            vendorRepository.save(Vendor.builder()
                            .firstName("Omar")
                            .lastName("Emad")
                            .build()).block();
            vendorRepository.save(Vendor.builder()
                            .firstName("Omar1")
                            .lastName("Emad1")
                            .build()).block();
            vendorRepository.save(Vendor.builder()
                            .firstName("Omar2")
                            .lastName("Emad2")
                            .build()).block();
            vendorRepository.save(Vendor.builder()
                            .firstName("Omar3")
                            .lastName("Emad3")
                            .build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());

        }

    }
}
