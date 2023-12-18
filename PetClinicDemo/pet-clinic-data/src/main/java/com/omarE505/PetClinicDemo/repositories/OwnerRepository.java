package com.omarE505.PetClinicDemo.repositories;

import com.omarE505.PetClinicDemo.models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
