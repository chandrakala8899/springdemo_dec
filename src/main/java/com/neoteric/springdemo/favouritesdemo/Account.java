package com.neoteric.springdemo.favouritesdemo;

import jakarta.persistence.*;

@Entity
@Table(name = "account_table",schema = "sonar")
public class Account {
    @Id
    private String mobileNumber;
    private String username;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}