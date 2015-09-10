package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TaxableItemTest {
    @Test
    public void shouldEqualsMethodReturnTrueForSameObjectsPassed() {
        TaxableItem taxableItem1 = new TaxableItem("book", 1, 10, .10);
        assertEquals(taxableItem1, taxableItem1);
    }

    @Test
    public void shouldReturnFalseIfItemNameIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 1, 10, .10);
        TaxableItem taxableItem2 = new TaxableItem("book22", 12, 101, .10);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnTrueIfItemNameIsSame() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 101, .10);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, .10);
        assertEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnFalseIfQuantityIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 10, .10);
        TaxableItem taxableItem2 = new TaxableItem("book", 1, 101, .10);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnFalseIfPriceIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 10, .10);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, .10);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnFalseIfTaxRateIsDifferent() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 10, .10);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, .11);
        assertNotEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnTrueIfAllAttributesAreSame() {
        TaxableItem taxableItem1 = new TaxableItem("book", 12, 101, .10);
        TaxableItem taxableItem2 = new TaxableItem("book", 12, 101, .10);
        assertEquals(taxableItem1, taxableItem2);
    }

    @Test
    public void shouldReturnPriceApplyingTaxValue() {
        TaxableItem taxableItem = new TaxableItem("perfume", 12, 10, .10);
        assertEquals(11.0, taxableItem.calculateSalesTax(), 0.001);
    }
}
