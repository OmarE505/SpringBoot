package com.omarE505.DependencyInjection.Controllers;

import com.omarE505.DependencyInjection.Services.SetterGreetingsService;
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