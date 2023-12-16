package com.omarE505.DependencyInjection.config;

import com.omarE505.DependencyInjection.repositories.EnglishGreetingRepository;
import com.omarE505.DependencyInjection.repositories.EnglishGreetingRepositoryImpl;
import com.omarE505.DependencyInjection.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    ConstructorGreetingsService constructorGreetingsService(){
        return new ConstructorGreetingsService();
    }

    @Bean
    PropertyGreetingsService propertyGreetingsService(){
        return new PropertyGreetingsService();
    }

    @Bean
    SetterGreetingsService setterGreetingsService(){
        return new SetterGreetingsService();
    }

    @Bean
    @Primary
    PrimaryGreetingsService primaryGreetingsService(){
        return new PrimaryGreetingsService();
    }

    @Bean
    @Profile("EN")
    I18NEnglishGreetingsService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18NEnglishGreetingsService(englishGreetingRepository);
    }

    @Bean("i18nService")
    @Profile({"ES","default"})
    I18NSpanishGreetingsService i18NSpanishGreetingsService(){
        return new I18NSpanishGreetingsService();
    }

}
