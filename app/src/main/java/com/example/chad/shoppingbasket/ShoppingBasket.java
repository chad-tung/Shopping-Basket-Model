package com.example.chad.shoppingbasket;

import android.bluetooth.BluetoothAssignedNumbers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chad on 27/11/2017.
 */

public class ShoppingBasket {
    private ArrayList<Item> shoppingList;
    private int totalCost;
    private HashMap<Item, Integer> listHash;

    public ShoppingBasket() {
        this.shoppingList = new ArrayList<>();
        this.totalCost = 0;
        this.listHash = new HashMap<>();
    }

    public ArrayList<Item> getShoppingList() {
        return shoppingList;
    }

    public int getTotalCost() {
        calculateCost();
        return totalCost;
    }

    public HashMap<Item, Integer> getListHash() {
        return listHash;
    }

    public void addItem(Item item) {
        this.shoppingList.add(item);
        updateHash(item);
    }

    public void removeItem(Item item) {
        this.shoppingList.remove(item);
        updateRemoveHash(item);
    }

    public void clearBasket() {
        this.shoppingList.clear();
        this.listHash.clear();
    }

    private void updateHash(Item item) {
        if (listHash.containsKey(item)) {
            listHash.put(item, listHash.get(item) + 1);
        } else {
            this.listHash.put(item, 1);
        }

    }

    private void updateRemoveHash(Item item) {
        listHash.put(item, listHash.get(item) - 1);
        if (listHash.get(item) == 0) {
            listHash.remove(item);
        }
    }

    private void calculateCost() {
        int cost = 0;
        for (Item item: listHash.keySet()) {
            if (item.isBuyOneGetOneFree()) {
                if (listHash.get(item) % 2 == 0) {
                    cost += (item.getCost() * listHash.get(item)) / 2;
                }
                else {
                    cost += (item.getCost() * (listHash.get(item) - 1) / 2);
                    cost += item.getCost();
                }
            }
            else {
                cost += item.getCost() * listHash.get(item);
            }
        }
        totalCost = cost;
    }

}
