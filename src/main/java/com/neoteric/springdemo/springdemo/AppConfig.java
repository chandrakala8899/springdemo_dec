package com.neoteric.springdemo.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.neoteric.springdemo.springdemo")
@EnableAspectJAutoProxy
public class AppConfig {
@Bean
    public Employee1 employee1(){
        return new Employee1();
    }
    @Bean
    public Employee2 employee2(){
    return new Employee2();
    }
    @Bean
    public Employee3 employee3(){
    return new Employee3();
    }
    @Bean
    public LockerAspectAcess lockerAccessAspect() {
        return new LockerAspectAcess();
    }
}
