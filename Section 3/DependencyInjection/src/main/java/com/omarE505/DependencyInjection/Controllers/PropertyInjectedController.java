package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.GreetingsService;

public class PropertyInjectedController {
    public GreetingsService greetingsService;

    public String getGreeting(){
        return greetingsService.sayGreetings();
    }
}
