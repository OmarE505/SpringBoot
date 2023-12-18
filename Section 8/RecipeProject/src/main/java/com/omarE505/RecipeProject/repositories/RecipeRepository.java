package com.omarE505.RecipeProject.repositories;

import com.omarE505.RecipeProject.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
