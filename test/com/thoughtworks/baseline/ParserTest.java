package com.thoughtworks.baseline;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldParseAndReturnItem() {
        final UnTaxableItem parsedInputUnTaxableItem = new UnTaxableItem("book at", 1, 12.49, 0);
        ArrayList<UnTaxableItem> unTaxableItems = new ArrayList<UnTaxableItem>() {{
            add(parsedInputUnTaxableItem);
        }};
        Parser parser = new Parser();

        assertEquals(unTaxableItems, parser.parse(new ArrayList<String>() {{
            add("1 book at 12.49");
        }}));
    }

    @Test
    public void shouldReturnItemName() {
        assertEquals("book at", new Parser().getItemName("1 book at 12.49"));
    }

    @Test
    public void shouldParseQuantityFromInputString() {
        assertEquals(1, new Parser().getQuantity("1 book at 12.49"));
    }

    @Test
    public void shouldParsePriceFromInputString() {
        assertEquals(12.49, new Parser().getPrice("1 book at 12.49"), 0.001);
    }

    @Test
    public void shouldParseAndReturnUntaxableItem() {
        Parser parser = new Parser();
        ArrayList<Item> items = parser.parse(new ArrayList<String>() {{
            add("1 book at 12.49");
        }});

        assertEquals(UnTaxableItem.class, items.get(0).getClass());
    }

    @Test
    public void shouldParseAndReturnTaxableItem() {
        Parser parser = new Parser();
        ArrayList<Item> items = parser.parse(new ArrayList<String>() {{
            add("1 imported bottle of perfume at 47.50");
        }});

        assertEquals(TaxableItem.class, items.get(0).getClass());
    }

    @Test
    public void shouldParseAndReturnTaxableItemWhichIsImported() {
        Parser parser = new Parser();
        ArrayList<Item> items = parser.parse(new ArrayList<String>() {{
            add("1 imported bottle of perfume at 47.50");
        }});

        assertEquals(new TaxableItem("imported bottle of perfume at", 1, 47.50, .15), items.get(0));
    }

    @Test
    public void shouldParseAndReturnTaxableItemWhichIsNotImported() {
        Parser parser = new Parser();
        ArrayList<Item> items = parser.parse(new ArrayList<String>() {{
            add("1 bottle of perfume at 47.50");
        }});

        assertEquals(new TaxableItem("bottle of perfume at", 1, 47.50, .10), items.get(0));
    }

    @Test
    public void shouldParseAndReturnUnTaxableItemWhichIsNotImported() {
        Parser parser = new Parser();
        ArrayList<Item> items = parser.parse(new ArrayList<String>() {{
            add("1 imported box of chocolates at 10.00");
        }});

        assertEquals(new UnTaxableItem("imported box of chocolates at", 1, 10.00, .05), items.get(0));
    }
}
