package com.omarE505.DependencyInjection.Services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingsService implements GreetingsService{

    @Override
    public String sayGreetings() {
        return "Hello World!!! - Setter";
    }
}
