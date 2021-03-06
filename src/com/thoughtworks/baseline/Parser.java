package com.thoughtworks.baseline;

import java.util.ArrayList;

//parsers the input list and returns the item
public class Parser {

    private ArrayList<String> validTaxableItems = new ArrayList<String>() {{
        add("music");
        add("perfume");
    }};

    private ArrayList<String> validUnTaxableItems = new ArrayList<String>() {{
        add("book");
        add("chocolate");
        add("pills");
    }};

    public ArrayList<Item> parse(ArrayList<String> inputItems) {
        ArrayList<Item> items = new ArrayList<>();
        Item parsedItem = null;

        for (String item : inputItems) {
            String itemName = getItemName(item);
            int quantity = getQuantity(item);
            Double price = getPrice(item);

            for (String validUnTaxableItem : validUnTaxableItems) {
                if (itemName.contains(validUnTaxableItem)) {
                    if (!itemName.contains("imported"))
                        parsedItem = new UnTaxableItem(itemName, quantity, price, 0);
                    else
                        parsedItem = new UnTaxableItem(itemName, quantity, price, 0.05);
                }
            }

            for (String validTaxableItem : validTaxableItems) {
                if (itemName.contains(validTaxableItem)) {
                    if (itemName.contains("imported"))
                        parsedItem = new TaxableItem(itemName, quantity, price, .15);
                    else
                        parsedItem = new TaxableItem(itemName, quantity, price, .10);
                }
            }

            items.add(parsedItem);
        }

        return items;
    }

    public int getQuantity(String item) {
        return Integer.parseInt(item.substring(0, item.indexOf(" ")));
    }

    public String getItemName(String item) {
        return item.substring(item.indexOf(" ") + 1, item.lastIndexOf(" "));
    }

    public Double getPrice(String item) {
        return Double.parseDouble(item.substring(item.lastIndexOf(" ")));
    }
}
