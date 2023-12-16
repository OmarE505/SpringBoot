package com.omarE505.DependencyInjection.Services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nService")
public class I18NEnglishGreetingsService implements GreetingsService{
    @Override
    public String sayGreetings() {
        return "Hello World!!! - EN";
    }
}
