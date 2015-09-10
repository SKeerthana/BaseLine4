package com.thoughtworks.baseline;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldParseAndReturnItem() {
        final UnTaxableItem parsedInputUnTaxableItem = new UnTaxableItem("book at", 1, 12.49);
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
}
