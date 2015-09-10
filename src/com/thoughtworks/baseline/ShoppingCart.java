package com.thoughtworks.baseline;

import java.util.ArrayList;

//contains the list of input items
public class ShoppingCart {
    private ArrayList<Item> items;

    public ShoppingCart(ArrayList<Item> items) {
        this.items = items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item :items)
            total += item.calculateSalesTax();
        return total;
    }
}
