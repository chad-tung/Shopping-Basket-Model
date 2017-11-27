package com.example.chad.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 27/11/2017.
 */

public class ShoppingBasketTest {
    private ShoppingBasket basket;
    private Item banana;
    private Item strawberry;
    private Item biscuits;

    @Before
    public void before() {
        basket = new ShoppingBasket();
        banana = new Item("Banana", 100);
        strawberry = new Item("Strawberry", 200);
        biscuits = new Item("Biscuits", 300);

        basket.addItem(banana);
        basket.addItem(strawberry);
    }

    @Test
    public void canAddItems() {
        assertEquals(2, basket.getShoppingList().size());
        basket.addItem(biscuits);
        assertEquals(3, basket.getShoppingList().size());
    }

    @Test
    public void canUpdateHash() {
        assertEquals(2, basket.getListHash().size());
        basket.addItem(strawberry);
        assertEquals(2, basket.getListHash().size());
        Integer expected = 2;
        assertEquals(expected, basket.getListHash().get(strawberry));


        basket.addItem(biscuits);
        assertEquals(3, basket.getListHash().size());
    }

    @Test
    public void canRemoveItems() {
        basket.removeItem(strawberry);
        assertEquals(1, basket.getShoppingList().size());
        assertEquals(banana, basket.getShoppingList().get(0));
    }

    @Test
    public void canClearBasket() {
        basket.clearBasket();
        assertEquals(0, basket.getShoppingList().size());
    }

    @Test
    public void canUpdateRemoveHashKeyWhenValueZero() {
        basket.removeItem(strawberry);
        assertEquals(1, basket.getListHash().size());
    }

    @Test
    public void doesNotRemoveHashKeyWhenValueNotZero() {
        basket.addItem(banana);
        assertEquals(2, basket.getListHash().size());
        basket.removeItem(banana);
        assertEquals(2, basket.getListHash().size());
    }

    @Test
    public void canCalculateCost() {
        assertEquals(300, basket.getTotalCost());
        basket.addItem(biscuits);
        assertEquals(600, basket.getTotalCost());

        basket.removeItem(banana);
        assertEquals(500, basket.getTotalCost());

        basket.clearBasket();
        assertEquals(0, basket.getTotalCost());
    }

    @Test
    public void considersBuyOneGetOneFree() {
        assertEquals(300, basket.getTotalCost());
        basket.addItem(strawberry);
        strawberry.setBuyOneGetOneFree();
        assertEquals(300, basket.getTotalCost());
        basket.addItem(strawberry);
        assertEquals(500, basket.getTotalCost());
    }

    @Test
    public void canStackBuyOneGetOneFree() {
        for (int i=0; 5 > i; i++) {
            basket.addItem(banana);
            basket.addItem(strawberry);
        }
        banana.setBuyOneGetOneFree();
        strawberry.setBuyOneGetOneFree();
        assertEquals(12, basket.getShoppingList().size());
        assertEquals(900, basket.getTotalCost());

        basket.removeItem(strawberry);
        assertEquals(11, basket.getShoppingList().size());
        assertEquals(900, basket.getTotalCost());
    }
}
