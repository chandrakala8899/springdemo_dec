package com.neoteric.springdemo.favouritesdemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/add")
    public String addFavorite(@RequestParam String mobileNumber, @RequestParam String favoriteItem) {
        try {
            favoriteService.addFavorite(mobileNumber, favoriteItem);
            return "Favorite item added successfully!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}