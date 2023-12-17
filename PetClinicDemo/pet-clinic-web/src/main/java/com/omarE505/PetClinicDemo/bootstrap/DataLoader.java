package com.omarE505.PetClinicDemo.bootstrap;

import com.omarE505.PetClinicDemo.models.Owner;
import com.omarE505.PetClinicDemo.models.Vet;
import com.omarE505.PetClinicDemo.services.OwnerService;
import com.omarE505.PetClinicDemo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Omar");
        owner1.setLastName("Emad");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Test");
        owner2.setLastName("test");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet");
        vet1.setLastName("1");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("2");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...!");
    }
}