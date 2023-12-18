package com.omarE505.PetClinicDemo.repositories;

import com.omarE505.PetClinicDemo.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
