package com.neoteric.springdemo.favouritesdemo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    private final AccountRepository accountRepository;
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(AccountRepository accountRepository, FavoriteRepository favoriteRepository) {
        this.accountRepository = accountRepository;
        this.favoriteRepository = favoriteRepository;
    }

    public void addFavorite(String mobileNumber, String favoriteItem) {
        if (mobileNumber == null || mobileNumber.isEmpty() || favoriteItem == null || favoriteItem.isEmpty()) {
            throw new IllegalArgumentException("Mobile number and favorite item cannot be empty");
        }

        Account account = accountRepository.findByMobileNumber(mobileNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found for mobile number: " + mobileNumber);
        }
        Favourite favorite = new Favourite();
        favorite.setFavoriteItem(favoriteItem);
        favorite.setAccount(account);

        favoriteRepository.save(favorite);

        System.out.println("Added favorite for mobile number: " + mobileNumber + " -> Item: " + favoriteItem);
    }
}