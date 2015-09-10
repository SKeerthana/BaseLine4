package com.thoughtworks.baseline;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void shouldCalculateTotalForItemsInShoppingCart() {
        ArrayList<String> inputItems = new ArrayList<>();
        inputItems.add("1 book at 0");
        inputItems.add("1 music CD at 0");
        inputItems.add("1 chocolate bar at 0");
        ArrayList<Item> items = new Parser().parse(inputItems);
        ShoppingCart testShoppingCart = new ShoppingCart(items);
        assertEquals(0, testShoppingCart.calculateTotal(), 0.001);
    }

    @Test
    public void shouldCalculateTotalForUnTaxableItem() {
        ArrayList<String> inputItems = new ArrayList<>();
        inputItems.add("1 book at 12.49");
        ArrayList<Item> items = new Parser().parse(inputItems);
        ShoppingCart testShoppingCart = new ShoppingCart(items);
        assertEquals(12.49, testShoppingCart.calculateTotal(), 0.001);
    }
}
