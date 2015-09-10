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

        for (String item : inputItems) {

            String itemName = getItemName(item);

            UnTaxableItem parsedInputUnTaxableItem = new UnTaxableItem(item, 0, 0);
            parsedInputUnTaxableItem.calculateSalesTax();
            items.add(parsedInputUnTaxableItem);
        }

        return items;
    }

    public String getItemName(String item) {
        return item.substring(item.indexOf(" ") + 1, item.lastIndexOf(" "));
    }
}
