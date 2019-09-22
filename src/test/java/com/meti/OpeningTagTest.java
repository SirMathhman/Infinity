package com.meti;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpeningTagTest {

    @Test
    void renderWithAttributes() {
        Map<String, String> attributeMap = new HashMap<>();
        attributeMap.put("src", "/source");
        attributeMap.put("alt", "An image.");
        Component attributes = new Attributes(attributeMap);
        Component element = new OpeningTag("img", attributes);
        assertEquals("<img alt=\"An image.\" src=\"/source\">", element.render());
    }

    @Test
    void render() {
        Component element = new OpeningTag("img");
        assertEquals("<img alt=\"An image.\" src=\"/source\">", element.render());
    }
}