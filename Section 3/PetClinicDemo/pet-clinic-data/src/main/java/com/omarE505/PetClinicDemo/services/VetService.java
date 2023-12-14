package com.omarE505.PetClinicDemo.services;

import com.omarE505.PetClinicDemo.models.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
