package com.omarE505.DependencyInjection.services;

public class PropertyGreetingsService implements GreetingsService{
    @Override
    public String sayGreetings() {
        return "Hello World!!! - Property";
    }
}
