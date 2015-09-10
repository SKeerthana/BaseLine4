package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TaxableItemTest {
    @Test
    public void shouldCalculateSalesTax() {
        TaxableItem taxableItem = new TaxableItem("book", 1, 10, false);
        assertEquals(10, taxableItem.calculateSalesTax(), 0);
    }

    @Test
    public void shouldEqualsMethodReturnTrueForSameObjectsPassed() {
        TaxableItem taxableItem1 = new TaxableItem("book", 1, 10, false);
        assertEquals(taxableItem1, taxableItem1);
    }

    @Test
    public void shouldReturnFalseIfItemNameIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 1, 10, false);
        TaxableItem taxableItem2 = new TaxableItem("book22", 12, 101, false);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnTrueIfItemNameIsSame() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 101, false);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, false);
        assertEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnFalseIfQuantityIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 10, false);
        TaxableItem taxableItem2 = new TaxableItem("book", 1, 101, false);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnFalseIfPriceIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 10, false);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, false);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnFlaseIfImportedValueIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 10, false);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, true);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnTrueIfAllAttributesAreSame() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 101, false);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, false);
        assertEquals(taxableItem1, taxableItem2);
    }
}
