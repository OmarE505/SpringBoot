package com.omarE505.DependencyInjection.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello World!!! EN";
    }
}
