package com.neoteric.springdemo.favouritesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) {
        try {
            accountService.createAccount(account.getMobileNumber(), account.getUsername());
            return "Account created successfully!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}