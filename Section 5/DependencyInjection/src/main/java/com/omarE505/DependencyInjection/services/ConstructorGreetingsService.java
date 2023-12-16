package com.omarE505.DependencyInjection.services;

public class ConstructorGreetingsService implements GreetingsService {
    @Override
    public String sayGreetings() {
        return "Hello world!!! - Constructor";
    }
}
