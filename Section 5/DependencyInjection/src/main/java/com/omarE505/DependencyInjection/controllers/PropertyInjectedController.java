package com.omarE505.DependencyInjection.controllers;

import com.omarE505.DependencyInjection.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Qualifier("propertyGreetingsService")
    @Autowired
    public GreetingsService greetingsService;

    public String getGreeting(){
        return greetingsService.sayGreetings();
    }
}
