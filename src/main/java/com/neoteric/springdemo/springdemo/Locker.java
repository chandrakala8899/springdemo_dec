package com.neoteric.springdemo.springdemo;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private static Map<String, String> lockerPermissions = new HashMap<>();

    static {
        lockerPermissions.put("Locker1", "Admin");
        lockerPermissions.put("Locker2", "Assistant Manager");
        lockerPermissions.put("Locker3", "Normal Employee");
    }

    public static boolean hasAccess(String role, String locker) {
        return lockerPermissions.getOrDefault(locker, "").equals(role);
    }

    public static boolean isValidLocker(String locker) {
        return lockerPermissions.containsKey(locker);
    }
}