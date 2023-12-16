package com.omarE505.DependencyInjection.services;

public class PrimaryGreetingsService implements GreetingsService {
    @Override
    public String sayGreetings() {
        return "Hello World!!! From PRIMARY service";
    }
}
