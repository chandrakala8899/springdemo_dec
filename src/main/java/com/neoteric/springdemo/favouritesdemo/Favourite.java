package com.neoteric.springdemo.favouritesdemo;

import jakarta.persistence.*;

@Entity
@Table(name = "favourite_table",schema = "sonar")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String favoriteItem;

    @ManyToOne
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFavoriteItem() {
        return favoriteItem;
    }

    public void setFavoriteItem(String favoriteItem) {
        this.favoriteItem = favoriteItem;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}