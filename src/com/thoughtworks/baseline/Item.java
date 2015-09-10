package com.thoughtworks.baseline;
//Stores details about the item
public class Item {
    private String itemName;
    private int quantity;
    private double price;

    public Item(String itemName, int quantity, double price) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
    }

    public double calculateSalesTax() {
        return price;
    }

    @Override
    public boolean equals(Object that) {
        if(that.getClass() != getClass())
            return false;
        return true;
    }

}
