package com.omarE505.DependencyInjection.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimaryGreetingsService implements GreetingsService {
    @Override
    public String sayGreetings() {
        return "Hello World!!! From PRIMARY service";
    }
}
