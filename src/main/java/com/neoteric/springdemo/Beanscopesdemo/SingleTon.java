package com.neoteric.springdemo.Beanscopesdemo;

import org.springframework.stereotype.Component;

@Component
public class SingleTon {

    public void executeSingletonTask() {
        System.out.println("Executing task in SingletonClass instance: " + this.hashCode());
    }
}
