package com.meti;

import com.meti.render.Component;
import com.meti.render.element.Attributes;
import com.meti.render.element.Group;
import com.meti.render.element.OpeningTag;
import com.meti.render.element.SimpleElementBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTMLTest {
    @Test
    void construct() {
        Map<String, String> values = new HashMap<>();
        values.put("id", "test0");
        values.put("name", "test1");
        Component attributes = new Attributes(values);
        Component html = new SimpleElementBuilder()
                .withTagName("html")
                .withAttributes(attributes)
                .build();
        Group group = new Group(new OpeningTag("!DOCTYPE html"), html);
        assertEquals("<!DOCTYPE html><html id=\"test0\" name=\"test1\"></html>", group.render());
    }
}
