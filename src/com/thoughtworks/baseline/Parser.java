package com.thoughtworks.baseline;

import java.util.ArrayList;

//parsers the input list and returns the item
public class Parser {

    private ArrayList<String> validItems = new ArrayList<String>() {{
        add("book");
        add("music");
        add("chocolate");
        add("perfume");
        add("pills");
    }};

    public ArrayList<Item> parse(ArrayList<String> inputItems) {
        ArrayList<Item> items = new ArrayList<Item>();
        for (String item : inputItems) {
            Item parsedInputItem = new Item(item, 0 , 0);
            parsedInputItem.calculateSalesTax();
            items.add(parsedInputItem);
        }
        return items;
    }
}
