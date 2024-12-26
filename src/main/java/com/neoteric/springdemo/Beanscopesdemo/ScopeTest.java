package com.neoteric.springdemo.Beanscopesdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SingleTon singleton1 = context.getBean(SingleTon.class);
        SingleTon singleton2 = context.getBean(SingleTon.class);
        singleton1.executeSingletonTask();
        singleton2.executeSingletonTask();

        Prototype prototype1 = context.getBean(Prototype.class);
        Prototype prototype2 = context.getBean(Prototype.class);
        prototype1.executePrototypeTask();
        prototype2.executePrototypeTask();
    }
}
