package com.omarE505.PetClinicDemo.services;

import com.omarE505.PetClinicDemo.models.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
