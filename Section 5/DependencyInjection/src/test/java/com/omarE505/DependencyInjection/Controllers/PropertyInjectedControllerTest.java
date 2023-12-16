package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.PropertyGreetingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {
    PropertyInjectedController controller;


    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingsService = new PropertyGreetingsService();
    }

    @Test
    void getGreetingsTest() {
        System.out.println(controller.getGreeting());
    }
}