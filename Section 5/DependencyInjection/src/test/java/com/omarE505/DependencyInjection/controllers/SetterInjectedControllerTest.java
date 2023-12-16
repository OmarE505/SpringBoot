package com.omarE505.DependencyInjection.controllers;

import com.omarE505.DependencyInjection.services.SetterGreetingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {
    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingsService(new SetterGreetingsService());
    }

    @Test
    void getGreetingTest(){
        System.out.println(controller.getGreeting());
    }


}