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

    public ArrayList<UnTaxableItem> parse(ArrayList<String> inputItems) {
        ArrayList<UnTaxableItem> unTaxableItems = new ArrayList<UnTaxableItem>();
        for (String item : inputItems) {
            UnTaxableItem parsedInputUnTaxableItem = new UnTaxableItem(item, 0 , 0);
            parsedInputUnTaxableItem.calculateSalesTax();
            unTaxableItems.add(parsedInputUnTaxableItem);
        }
        return unTaxableItems;
    }
}
