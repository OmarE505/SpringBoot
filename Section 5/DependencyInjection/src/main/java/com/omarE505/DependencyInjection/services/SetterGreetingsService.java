package com.omarE505.DependencyInjection.services;

public class SetterGreetingsService implements GreetingsService{

    @Override
    public String sayGreetings() {
        return "Hello World!!! - Setter";
    }
}
