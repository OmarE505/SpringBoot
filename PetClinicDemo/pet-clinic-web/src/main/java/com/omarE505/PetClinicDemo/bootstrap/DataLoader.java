package com.omarE505.PetClinicDemo.bootstrap;

import com.omarE505.PetClinicDemo.models.Owner;
import com.omarE505.PetClinicDemo.models.Pet;
import com.omarE505.PetClinicDemo.models.PetType;
import com.omarE505.PetClinicDemo.models.Vet;
import com.omarE505.PetClinicDemo.services.OwnerService;
import com.omarE505.PetClinicDemo.services.PetTypeService;
import com.omarE505.PetClinicDemo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Omar");
        owner1.setLastName("Emad");
        owner1.setAddress("15 May");
        owner1.setCity("Cairo");
        owner1.setTelephone("123123123");

        Pet omarsPet = new Pet();
        omarsPet.setPetType(savedDogType);
        omarsPet.setOwner(owner1);
        omarsPet.setBirthDate(LocalDate.now());
        omarsPet.setName("liza");

        owner1.getPets().add(omarsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Test");
        owner2.setLastName("test");
        owner1.setAddress("May");
        owner1.setCity("Alexandria");
        owner1.setTelephone("1231223323123");

        Pet testPet = new Pet();
        testPet.setName("Test Cat");
        testPet.setOwner(owner2);
        testPet.setBirthDate(LocalDate.now());
        testPet.setPetType(savedCatType);
        owner2.getPets().add(testPet);

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
