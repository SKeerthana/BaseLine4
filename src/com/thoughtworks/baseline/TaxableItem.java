package com.thoughtworks.baseline;

public class TaxableItem {
    private String itemName;
    private int quantity;
    private double price;
    private boolean imported;

    public TaxableItem(String itemName, int quantity, double price, boolean imported) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.imported = imported;
    }

    public double calculateSalesTax() {
        return price;
    }

    @Override
    public boolean equals(Object that) {
        if (that.getClass() != getClass())
            return false;
        TaxableItem thatTaxableItem = (TaxableItem) that;
        if (thatTaxableItem.itemName.equals(itemName) && thatTaxableItem.quantity == (quantity) && thatTaxableItem.price == price)
            return true;
        return false;
    }
}
