package com.example.chad.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by chad on 27/11/2017.
 */

public class CustomerTest {
    private Customer customer1;
    private Customer customer2;
    private Item banana;
    private Item strawberry;

    @Before
    public void before() {
        customer1 = new Customer("Chad");
        customer2 = new Customer("Jayne", true);
        banana = new Item("Banana", 100);
        strawberry = new Item("Strawberry", 200);
        customer2.addToBasket(strawberry);
        customer2.addToBasket(banana);
    }

    @Test
    public void canCheckLoyaltyCard() {
        assertFalse(customer1.hasLoyaltyCard());
        assertTrue(customer2.hasLoyaltyCard());
    }

    @Test
    public void canApplyForLoyaltyCard() {
        customer1.applyForLoyaltyCard();
        assertTrue(customer1.hasLoyaltyCard());
    }

    @Test
    public void canAddItemsToBasket() {
        customer1.addToBasket(banana);
        assertEquals(1, customer1.getBasket().getShoppingList().size());
    }


    @Test
    public void canRemoveItemsFromBasket() {
        customer2.removeFromBasket(banana);
        assertEquals(1, customer2.getBasket().getShoppingList().size());
    }

    @Test
    public void canEmptyBasket() {
        customer2.emptyBasket();
        assertEquals(0, customer2.getBasket().getShoppingList().size());
    }

    @Test
    public void canCheckTotal() {
        assertEquals(0, customer1.checkBasketTotal());
        assertEquals(300, customer2.checkBasketTotal());
    }

    @Test
    public void canGetListHash() {
        assertEquals(0, customer1.getBasketHash().size());
        assertEquals(2, customer2.getBasketHash().size());
    }
}
