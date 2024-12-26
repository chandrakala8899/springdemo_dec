package com.neoteric.springdemo.springdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LockerAspectAcess {

    @Pointcut("execution(* Employee1.performAdminTask(..)) || " +
            "execution(* Employee2.performAssistantMaganerTask(..)) || " +
            "execution(* Employee3.normalEmployeeTsk(..))")
    public void lockerAccessMethods() {}

    @Around("lockerAccessMethods() && args(role, locker)")
    public Object validateLockerAccess(ProceedingJoinPoint joinPoint, Roll role, String locker) throws Throwable {
        if (!Locker.isValidLocker(locker)) {
            throw new RuntimeException("Invalid locker: " + locker);
        }
        if (!Locker.hasAccess(role.getName(), locker)) {
            throw new RuntimeException("Access denied for " + role.getName() + " to " + locker);
        }
        return joinPoint.proceed();
    }
}