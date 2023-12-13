package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.GreetingsService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingsService greetingsService;

    public MyController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    public String sayHello(){
        return greetingsService.sayGreetings();
    }
}
