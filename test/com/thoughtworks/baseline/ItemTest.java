package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ItemTest {
    @Test
    public void shouldCalculateSalesTax() {
        Item item = new Item("book", 1, 10);
        assertEquals(10, item.calculateSalesTax(), 0);
    }

    @Test
    public void shouldEqualsMethodReturnTrueForSameObjectsPassed() {
        Item item1 = new Item("book", 1, 10);
        assertEquals(item1, item1);
    }

    @Test
    public void shouldReturnFalseIfItemNameIsDifferent() {
        Item item1 = new Item("book", 1, 10);
        Item item2 = new Item("book22", 12, 101);
        assertNotEquals(item1, item2);
    }

    @Test
    public void shouldReturnTrueIfItemNameIsSame() {
        Item item1 = new Item("book", 12, 101);
        Item item2 = new Item("book", 12, 101);
        assertEquals(item1, item2);
    }

    @Test
    public void shouldReturnFalseIfQuantityIsDifferent() {
        Item item1 = new Item("book", 12, 10);
        Item item2 = new Item("book", 1, 101);
        assertNotEquals(item1, item2);
    }

    @Test
    public void shouldReturnFalseIfPriceIsDifferent() {
        Item item1 = new Item("book", 12, 10);
        Item item2 = new Item("book", 12, 101);
        assertNotEquals(item1, item2);
    }
}
