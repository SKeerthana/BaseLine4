package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
