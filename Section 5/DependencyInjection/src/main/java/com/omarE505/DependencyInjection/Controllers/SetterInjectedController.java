package com.omarE505.DependencyInjection.controllers;

import com.omarE505.DependencyInjection.services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {
    private GreetingsService greetingsService;

    @Autowired
    @Qualifier("setterGreetingsService")
    public void setGreetingsService(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    public String getGreeting(){
        return greetingsService.sayGreetings();
    }
}
