package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.ConstructorGreetingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new ConstructorGreetingsService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}