package com.meti.render;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributeTagTest {

    @Test
    void renderClosing() {
        Tag tag = new AttributeTag("div", new MapAttributes());
        assertEquals("</div>", tag.renderClosing());
    }

    @Test
    void renderOpening() {
        Attributes attributes = new MapAttributes();
        attributes.put("id", "foo");
        Tag tag = new AttributeTag("div", attributes);
        assertEquals("<div id=\"foo\">", tag.renderOpening());
    }
}