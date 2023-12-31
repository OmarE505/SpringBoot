package com.omarE505.DependencyInjection;

import com.omarE505.DependencyInjection.config.OmarConfiguration;
import com.omarE505.DependencyInjection.config.OmarConstructorConfig;
import com.omarE505.DependencyInjection.controllers.*;
import com.omarE505.DependencyInjection.datasource.FakeDataSource;
import com.omarE505.DependencyInjection.services.PrototypeBean;
import com.omarE505.DependencyInjection.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet Is ---");
        System.out.println(petController.whichPetIsTheBest());

        I18NController i18NController = (I18NController) ctx.getBean("i18NController");
        System.out.println(i18NController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");
        System.out.println("-------- Primary");
        System.out.println(myController.sayHello());

        System.out.println("-------- property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("-------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("----------- Bean Scopes -------------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        System.out.println("-------------- Fake Data Source");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcurl());

        System.out.println("------------- Config props Bean");
        OmarConfiguration omarConfiguration = ctx.getBean(OmarConfiguration.class);
        System.out.println(omarConfiguration.getUsername());
        System.out.println(omarConfiguration.getPassword());
        System.out.println(omarConfiguration.getJdbcurl());

        System.out.println("------------- Constructor Binding");
        OmarConstructorConfig omarConstructorConfig = ctx.getBean(OmarConstructorConfig.class);
        System.out.println(omarConstructorConfig.getUsername());
        System.out.println(omarConstructorConfig.getPassword());
        System.out.println(omarConstructorConfig.getJdbcurl());
    }

}
