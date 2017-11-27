package com.example.chad.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by chad on 27/11/2017.
 */

public class ItemTest {
    private Item banana;

    @Before
    public void before() {
        banana = new Item("Banana", 100);
    }

    @Test
    public void getCost() {
        assertEquals(100, banana.getCost());
    }

    @Test
    public void getName() {
        assertEquals("Banana", banana.getName());
    }

    @Test
    public void isBuyOneGetOneFree() {
        assertFalse(banana.isBuyOneGetOneFree());
    }

    @Test
    public void canSetBuyOneGetOneFree() {
        banana.setBuyOneGetOneFree();
        assertTrue(banana.isBuyOneGetOneFree());
    }

    @Test
    public void canResetBuyOneGetOneFree() {
        banana.setBuyOneGetOneFree();
        banana.removeBuyOneGetOneFree();
        assertFalse(banana.isBuyOneGetOneFree());
    }
}
