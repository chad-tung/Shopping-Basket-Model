package com.example.chad.shoppingbasket;

/**
 * Created by chad on 27/11/2017.
 */

public class DiscountStaff {
    private String name;

    public DiscountStaff(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void applyDiscount(Item item) {
        item.setBuyOneGetOneFree();
    }

    public void removeDiscount(Item item) {
        item.removeBuyOneGetOneFree();
    }

    public void issueLoyaltyCard(Customer customer) {
        customer.applyForLoyaltyCard();
    }
}
