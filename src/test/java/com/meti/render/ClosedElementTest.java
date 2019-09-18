package com.meti.render;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosedElementTest {

    @Test
    void renderWithChildren() {
        ElementContent headContent = new SimpleElementContent();
        headContent.append(new ClosedElementBuilder()
                .withTagName("title")
                .withContent(new SimpleElementContent().append("Title"))
                .build());
        Component element = new ClosedElementBuilder()
                .withTagName("head")
                .withContent(headContent)
                .build();
        assertEquals("<head><title>Title</title></head>", element.render());
    }

    @Test
    void renderWithAttributes() {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("id", "content");
        Component component = new ClosedElementBuilder()
                .withTagName("p")
                .withContent(new SimpleElementContent().append("Hello World!"))
                .withAttributes(new MapAttributes(attributes))
                .build();
        assertEquals("<p id=\"content\">Hello World!</p>", component.render());
    }
}