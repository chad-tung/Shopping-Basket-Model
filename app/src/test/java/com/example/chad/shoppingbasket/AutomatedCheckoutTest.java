package com.example.chad.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by chad on 27/11/2017.
 */

public class AutomatedCheckoutTest {
    AutomatedCheckout till = new AutomatedCheckout();
    DiscountStaff staff;
    Customer student;
    Customer instructor;
    Item luxuryToiletRoll;
    Item cheapToiletRoll;
    Item tableTennisBat;

    @Before
    public void before() {
        staff = new DiscountStaff("Senga");
        student = new Customer("Chad");
        instructor = new Customer("Ally", true);
        luxuryToiletRoll = new Item("Cushelle 50 pack", 2000);
        cheapToiletRoll = new Item("One ply, good luck 100 pack", 600);
        tableTennisBat = new Item("Table tennis bat", 1000);
        staff.applyDiscount(tableTennisBat);
    }

    @Test
    public void canCheckForLoyaltyCard() {
        assertTrue(till.checkLoyaltyCard(instructor));
        assertFalse(till.checkLoyaltyCard(student));

        assertEquals(0.02, till.loyaltyDiscount(instructor), 0.001);
        assertEquals(0, till.loyaltyDiscount(student), 0.001);
    }

    @Test
    public void canCheckTwentyThreshold() {
        instructor.addToBasket(luxuryToiletRoll);
        student.addToBasket(cheapToiletRoll);

        assertTrue(till.overTwentyThreshold(instructor));
        assertFalse(till.overTwentyThreshold(student));

        assertEquals(0.1, till.overTwentyDiscount(instructor), 0.01);
        assertEquals(0.0, till.overTwentyDiscount(student), 0.01);
    }


    @Test
    public void checkoutPrices() {
        instructor.addToBasket(luxuryToiletRoll);
        assertEquals(1764, till.checkout(instructor));

        student.addToBasket(cheapToiletRoll);
        student.addToBasket(tableTennisBat);
        student.addToBasket(tableTennisBat);

        assertEquals(1600, till.checkout(student));
        student.addToBasket(tableTennisBat);
        assertEquals(2340, till.checkout(student));
        student.addToBasket(tableTennisBat);
        assertEquals(2340, till.checkout(student));
    }
}
