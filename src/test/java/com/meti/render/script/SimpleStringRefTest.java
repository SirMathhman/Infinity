package com.meti.render.script;

import com.meti.render.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleStringRefTest {

    @Test
    void concat() {
        StringRef a = SimpleStringRef.$("a");
        StringRef b = SimpleStringRef.$("b");
        StringRef c = SimpleStringRef.$("c");
        StringRef concat = a.concat(b).concat(c);
        assertEquals("\"a\"+\"b\"+\"c\"", concat.render());
    }

    @Test
    void copy() {
        StringRef parent = new SimpleStringRef("foo");
        StringRef child = parent.copy("bar");
        assertEquals("bar", child.render());
    }

    @Test
    void render() {
        Component component = new SimpleStringRef("content");
        assertEquals("content", component.render());
    }

    @Test
    void of() {
        Component value = SimpleStringRef.$("test");
        assertEquals("\"test\"", value.render());
    }
}