package com.example.chad.shoppingbasket;

/**
 * Created by chad on 27/11/2017.
 */

public class Item {
    private String name;
    private int cost;
    private boolean buyOneGetOneFree;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.buyOneGetOneFree = false;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean isBuyOneGetOneFree() {
        return buyOneGetOneFree;
    }

    public void setBuyOneGetOneFree() {
        this.buyOneGetOneFree = true;
    }

    public void removeBuyOneGetOneFree() {
        this.buyOneGetOneFree = false;
    }
}
