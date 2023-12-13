package com.omarE505.DependencyInjection.Controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello(){
        System.out.println("Hello world");

        return "Hello";
    }
}
