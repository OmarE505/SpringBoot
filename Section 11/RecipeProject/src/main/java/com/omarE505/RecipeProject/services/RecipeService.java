package com.omarE505.RecipeProject.services;

import com.omarE505.RecipeProject.commands.RecipeCommand;
import com.omarE505.RecipeProject.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
