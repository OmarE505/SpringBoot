package com.omarE505.DependencyInjection.controllers;

import com.omarE505.DependencyInjection.services.GreetingsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private final GreetingsService greetingsService;

    public ConstructorInjectedController(@Qualifier("constructorGreetingsService") GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    public String getGreeting(){
        return greetingsService.sayGreetings();
    }
}
