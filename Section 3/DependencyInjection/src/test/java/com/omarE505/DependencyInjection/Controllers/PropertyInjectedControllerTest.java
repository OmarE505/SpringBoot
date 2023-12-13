package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.GreetingsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {
    PropertyInjectedController controller;


    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingsService = new GreetingsServiceImpl();
    }

    @Test
    void getGreetingsTest() {
        System.out.println(controller.getGreeting());
    }
}