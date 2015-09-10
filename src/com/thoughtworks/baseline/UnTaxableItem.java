package com.thoughtworks.baseline;

//Stores details about the untaxable items
public class UnTaxableItem implements Item {
    private String itemName;
    private int quantity;
    private double price;
    private double importTaxRate;

    public UnTaxableItem(String itemName, int quantity, double price, double importTaxRate) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
        this.importTaxRate = importTaxRate;
    }

    public double calculateSalesTax() {
        return price;
    }

    @Override
    public boolean equals(Object that) {
        if (that.getClass() != getClass())
            return false;
        UnTaxableItem thatUnTaxableItem = (UnTaxableItem) that;
        if (thatUnTaxableItem.itemName.equals(itemName) && thatUnTaxableItem.quantity == (quantity) && thatUnTaxableItem.price == price)
            return true;
        return false;
    }

}
