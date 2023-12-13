package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Autowired
    public GreetingsService greetingsService;

    public String getGreeting(){
        return greetingsService.sayGreetings();
    }
}
