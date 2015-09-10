package com.thoughtworks.baseline;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldParseAndReturnItem() {
        final Item parsedInputItem = new Item("1 book at 12.49", 0, 0);
        ArrayList<Item> items = new ArrayList<Item>() {{
            add(parsedInputItem);
        }};
        Parser parser = new Parser();
        assertEquals(items, parser.parse(new ArrayList<String>() {{
            add("1 book at 12.49");
        }}));

    }
}
