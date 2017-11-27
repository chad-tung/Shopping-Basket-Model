package com.example.chad.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by chad on 27/11/2017.
 */

public class DiscountStaffTest {

    private DiscountStaff staff1;
    private Item bread;
    private Customer customer1;

    @Before
    public void before() {
        staff1 = new DiscountStaff("Stevie");
        customer1 = new Customer("Gerry");
        bread = new Item("Bread", 500);
    }

    @Test
    public void canApplyDiscount() {
        assertFalse(bread.isBuyOneGetOneFree());
        staff1.applyDiscount(bread);
        assertTrue(bread.isBuyOneGetOneFree());
    }

    @Test
    public void canRemoveDiscount() {
        staff1.applyDiscount(bread);

        staff1.removeDiscount(bread);
        assertFalse(bread.isBuyOneGetOneFree());
    }

    @Test
    public void canIssueLoyaltyCard() {
        assertFalse(customer1.hasLoyaltyCard());
        staff1.issueLoyaltyCard(customer1);
        assertTrue(customer1.hasLoyaltyCard());
    }
}
