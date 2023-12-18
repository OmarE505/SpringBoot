package com.omarE505.PetClinicDemo.repositories;

import com.omarE505.PetClinicDemo.models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByLastName(String lastName);
}
