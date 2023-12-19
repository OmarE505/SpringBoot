package com.omarE505.PetClinicDemo.bootstrap;

import com.omarE505.PetClinicDemo.models.*;
import com.omarE505.PetClinicDemo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality denstistry = new Speciality();
        denstistry.setDescription("Dentistry");

        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(denstistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(testPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sick Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners ...!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet");
        vet1.setLastName("1");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("2");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets ...!");
    }
}
