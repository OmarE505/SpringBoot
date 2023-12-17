package com.omarE505.DependencyInjection.config;

import com.omarE505.DependencyInjection.datasource.FakeDataSource;
import com.omarE505.DependencyInjection.repositories.EnglishGreetingRepository;
import com.omarE505.DependencyInjection.repositories.EnglishGreetingRepositoryImpl;
import com.omarE505.DependencyInjection.services.*;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
@EnableConfigurationProperties(OmarConstructorConfig.class)
@ImportResource("classpath:omar-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(OmarConstructorConfig omarConstructorConfig) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(omarConstructorConfig.getUsername());
        fakeDataSource.setPassword(omarConstructorConfig.getPassword());
        fakeDataSource.setJdbcurl(omarConstructorConfig.getJdbcurl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    PropertyGreetingsService propertyGreetingsService() {
        return new PropertyGreetingsService();
    }

    @Bean
    SetterGreetingsService setterGreetingsService() {
        return new SetterGreetingsService();
    }

    @Bean
    @Primary
    PrimaryGreetingsService primaryGreetingsService() {
        return new PrimaryGreetingsService();
    }

    @Bean
    @Profile("EN")
    I18NEnglishGreetingsService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18NEnglishGreetingsService(englishGreetingRepository);
    }

    @Bean("i18nService")
    @Profile({"ES", "default"})
    I18NSpanishGreetingsService i18NSpanishGreetingsService() {
        return new I18NSpanishGreetingsService();
    }

}
