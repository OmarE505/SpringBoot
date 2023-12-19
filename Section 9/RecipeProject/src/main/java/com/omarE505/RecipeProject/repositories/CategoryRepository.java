package com.omarE505.RecipeProject.repositories;

import com.omarE505.RecipeProject.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
