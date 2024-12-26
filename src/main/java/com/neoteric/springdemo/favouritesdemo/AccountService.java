package com.neoteric.springdemo.favouritesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String mobileNumber, String username) {
        if (accountRepository.existsById(mobileNumber)) {
            throw new IllegalArgumentException("Account already exists with this mobile number");
        }

        Account account = new Account();
        account.setMobileNumber(mobileNumber);
        account.setUsername(username);

        accountRepository.save(account);
        System.out.println("Account created for mobile number: " + mobileNumber);
    }
}
