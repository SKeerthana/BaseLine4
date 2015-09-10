package com.thoughtworks.baseline;

//Stores details about the taxable items
public class TaxableItem implements Item{
    private String itemName;
    private int quantity;
    private double price;
    private double taxRate;

    public TaxableItem(String itemName, int quantity, double price, Double taxRate) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.taxRate = taxRate;
    }

    public double calculateSalesTax() {
        return price + Math.ceil(taxRate * price * 20) / 20;
    }

    @Override
    public boolean equals(Object that) {
        if (that.getClass() != getClass())
            return false;
        TaxableItem thatTaxableItem = (TaxableItem) that;
        if (thatTaxableItem.itemName.equals(itemName) && thatTaxableItem.quantity == quantity
                && thatTaxableItem.price == price && thatTaxableItem.taxRate == taxRate)
            return true;
        return false;
    }
}
