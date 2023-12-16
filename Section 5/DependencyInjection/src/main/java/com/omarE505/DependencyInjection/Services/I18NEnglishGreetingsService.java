package com.omarE505.DependencyInjection.services;


import com.omarE505.DependencyInjection.repositories.EnglishGreetingRepository;

public class I18NEnglishGreetingsService implements GreetingsService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18NEnglishGreetingsService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreetings() {
        return "Hello World!!! - EN";
    }
}
