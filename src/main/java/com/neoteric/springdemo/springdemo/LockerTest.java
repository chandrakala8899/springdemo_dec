package com.neoteric.springdemo.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LockerTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee1 admin = context.getBean(Employee1.class);
        Employee2 assistantManager = context.getBean(Employee2.class);
        Employee3 normalEmployee = context.getBean(Employee3.class);

        Roll adminRoll = new Roll("Admin");
        Roll assistantManagerRoll = new Roll("Assistant Manager");
        Roll normalEmployeeRoll = new Roll("Normal Employee");

        try {
            admin.performAdminTask(adminRoll, "Locker1");

            assistantManager.performAssistantMaganerTask(assistantManagerRoll, "Locker2");

            normalEmployee.normalEmployeeTsk(normalEmployeeRoll, "Locker3");

            admin.performAdminTask(adminRoll, "Locker1");
            assistantManager.performAssistantMaganerTask(assistantManagerRoll, "Locker2");
            normalEmployee.normalEmployeeTsk(normalEmployeeRoll,"locker2");

        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}



