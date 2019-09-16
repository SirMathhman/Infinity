package com.meti.render;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClosedElementTest {

    @Test
    void renderWithChildren() {
        ElementContent headContent = new SimpleElementContent();
        headContent.append(new ClosedElement("title", new SimpleElementContent().append("Title")));
        Component element = new ClosedElement("head", headContent);
        assertEquals("<head><title>Title</title></head>", element.render());
    }
}