package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnTaxableItemTest {
    @Test
    public void shouldCalculateSalesTax() {
        UnTaxableItem unTaxableItem = new UnTaxableItem("book", 1, 10);
        assertEquals(10, unTaxableItem.calculateSalesTax(), 0);
    }

    @Test
    public void shouldEqualsMethodReturnTrueForSameObjectsPassed() {
        UnTaxableItem unTaxableItem1 = new UnTaxableItem("book", 1, 10);
        assertEquals(unTaxableItem1, unTaxableItem1);
    }

    @Test
    public void shouldReturnFalseIfItemNameIsDifferent() {
        UnTaxableItem unTaxableItem1 = new UnTaxableItem("book", 1, 10);
        UnTaxableItem unTaxableItem2 = new UnTaxableItem("book22", 12, 101);
        assertNotEquals(unTaxableItem1, unTaxableItem2);
    }

    @Test
    public void shouldReturnTrueIfItemNameIsSame() {
        UnTaxableItem unTaxableItem1 = new UnTaxableItem("book", 12, 101);
        UnTaxableItem unTaxableItem2 = new UnTaxableItem("book", 12, 101);
        assertEquals(unTaxableItem1, unTaxableItem2);
    }

    @Test
    public void shouldReturnFalseIfQuantityIsDifferent() {
        UnTaxableItem unTaxableItem1 = new UnTaxableItem("book", 12, 10);
        UnTaxableItem unTaxableItem2 = new UnTaxableItem("book", 1, 101);
        assertNotEquals(unTaxableItem1, unTaxableItem2);
    }

    @Test
    public void shouldReturnFalseIfPriceIsDifferent() {
        UnTaxableItem unTaxableItem1 = new UnTaxableItem("book", 12, 10);
        UnTaxableItem unTaxableItem2 = new UnTaxableItem("book", 12, 101);
        assertNotEquals(unTaxableItem1, unTaxableItem2);
    }

    @Test
    public void shouldReturnTrueIfAllAttributesAreSame() {
        UnTaxableItem unTaxableItem1 = new UnTaxableItem("book", 12, 101);
        UnTaxableItem unTaxableItem2 = new UnTaxableItem("book", 12, 101);
        assertEquals(unTaxableItem1, unTaxableItem2);
    }
}
