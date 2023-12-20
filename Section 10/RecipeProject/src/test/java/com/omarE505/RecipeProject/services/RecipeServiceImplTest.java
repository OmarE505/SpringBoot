package com.omarE505.RecipeProject.services;

import com.omarE505.RecipeProject.models.Recipe;
import com.omarE505.RecipeProject.repositories.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception {

        Recipe recipe = new Recipe();
        HashSet receipesData = new HashSet();
        receipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(receipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        Assertions.assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}