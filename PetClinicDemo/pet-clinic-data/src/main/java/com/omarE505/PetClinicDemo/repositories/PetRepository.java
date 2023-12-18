package com.omarE505.PetClinicDemo.repositories;

import com.omarE505.PetClinicDemo.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
