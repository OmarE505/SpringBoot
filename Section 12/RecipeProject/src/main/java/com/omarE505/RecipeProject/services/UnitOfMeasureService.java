package com.omarE505.RecipeProject.services;

import com.omarE505.RecipeProject.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
