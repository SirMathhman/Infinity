package com.meti.render;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleElementContentTest {
    @Test
    void construct() {
        ElementContent content = new SimpleElementContent();
        content = content.append("test");
        content = content.append(new ClosedElementBuilder()
                .withTagName("h1")
                .withContent(new SimpleElementContent())
                .build());
        Assertions.assertEquals("test<h1></h1>", content.render());
    }
}