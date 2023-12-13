package com.omarE505.DependencyInjection.Services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18nService")
public class I18NSpanishGreetingsService implements GreetingsService{
    @Override
    public String sayGreetings() {
        return "Hola Mundo!!! - ES";
    }
}
