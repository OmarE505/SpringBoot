package com.omarE505.DependencyInjection.Services;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingsService implements GreetingsService{
    @Override
    public String sayGreetings() {
        return "Hello World!!! - Property";
    }
}
