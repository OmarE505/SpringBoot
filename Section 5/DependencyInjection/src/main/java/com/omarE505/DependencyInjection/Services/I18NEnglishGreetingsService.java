package com.omarE505.DependencyInjection.services;


public class I18NEnglishGreetingsService implements GreetingsService{
    @Override
    public String sayGreetings() {
        return "Hello World!!! - EN";
    }
}
