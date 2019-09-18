package com.meti.render;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenElementTest {
    @Test
    void construct() {
        Component element = new OpenElement("foo");
        assertEquals("<foo>", element.render());
    }

    @Test
    void constructWithoutAttributes() {
        Component element = new OpenElement("test");
        assertEquals("<test>", element.render());
    }

    @Test
    void constructWithAttributes() {
        Map<String, String> attributeMap = new HashMap<>();
        attributeMap.put("id", "test");
        Component attributes = new MapAttributes(attributeMap);
        Component element = new OpenElement("input", attributes);
        assertEquals("<input id=\"test\">", element.render());
    }
}