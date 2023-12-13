package com.omarE505.DependencyInjection.Services;

import org.springframework.stereotype.Service;

@Service
public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayGreetings() {
        return "Hello world!!!";
    }
}
