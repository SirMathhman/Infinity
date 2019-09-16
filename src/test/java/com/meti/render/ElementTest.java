package com.meti.render;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElementTest {

    @Test
    void renderWithChildren() {
        ElementContent headContent = new SimpleElementContent();
        headContent.append(new Element("title", "Title"));
        Component element = new Element("head", headContent);
        assertEquals("<head><title>Title</title></head>", element.render());
    }
}