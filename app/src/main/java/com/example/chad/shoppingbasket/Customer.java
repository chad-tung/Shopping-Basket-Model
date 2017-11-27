package com.example.chad.shoppingbasket;

import java.util.HashMap;

/**
 * Created by chad on 27/11/2017.
 */

public class Customer {
    private ShoppingBasket basket;
    private boolean loyaltyCard;
    private String name;

    public Customer(String name, boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
        this.name = name;
        basket = new ShoppingBasket();
    }

    public Customer(String name) {
        this.name = name;
        this.loyaltyCard = false;
        basket = new ShoppingBasket();
    }

    public boolean hasLoyaltyCard() {
        return loyaltyCard;
    }

    public void applyForLoyaltyCard() {
        this.loyaltyCard = true;
    }

    public ShoppingBasket getBasket() {
        return this.basket;
    }

    public HashMap<Item, Integer> getBasketHash() {
        return this.basket.getListHash();
    }

    public int checkBasketTotal() {
        return basket.getTotalCost();
    }

    public void addToBasket(Item item) {
        basket.addItem(item);
    }

    public void removeFromBasket(Item item) {
        basket.removeItem(item);
    }

    public void emptyBasket() {
        basket.clearBasket();
    }
}
