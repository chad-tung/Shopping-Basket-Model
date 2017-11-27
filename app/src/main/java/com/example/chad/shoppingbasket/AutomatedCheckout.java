package com.example.chad.shoppingbasket;

/**
 * Created by chad on 27/11/2017.
 */

public class AutomatedCheckout {
    public AutomatedCheckout() {
    }

    public boolean checkLoyaltyCard(Customer customer) {
        return customer.hasLoyaltyCard();
    }

    public boolean overTwentyThreshold(Customer customer) {
        return (customer.checkBasketTotal() >= 2000) ;
    }

    public double overTwentyDiscount(Customer customer) {
        if (overTwentyThreshold(customer)) {
            return 0.1;
        }
        else {
            return 0;
        }
    }

    public double loyaltyDiscount(Customer customer) {
        if (checkLoyaltyCard(customer)) {
            return 0.02;
        }
        else {
            return 0;
        }
    }

    public int checkout(Customer customer) {
//        This is really the class where I should have implemented the buy one get one free logic
        int total = customer.checkBasketTotal();
//        10% discount check
        total -= total * overTwentyDiscount(customer);
//        loyalty discount check
        total -= total * loyaltyDiscount(customer);

        return total;
    }
}
