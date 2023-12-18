package com.omarE505.RecipeProject.controllers;

import com.omarE505.RecipeProject.models.Category;
import com.omarE505.RecipeProject.models.UnitOfMeasure;
import com.omarE505.RecipeProject.repositories.CategoryRepository;
import com.omarE505.RecipeProject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(){

        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is :" + category.get().getId());
        System.out.println("UOM Id is :" + unitOfMeasure.get().getId());

        return "index";
    }
}
