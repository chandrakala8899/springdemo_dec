package com.neoteric.springdemo.Beanscopesdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Prototype {
    public void executePrototypeTask() {
        System.out.println("Executing task in PrototypeClass instance: " + this.hashCode());
    }
}
