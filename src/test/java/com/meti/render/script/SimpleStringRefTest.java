package com.meti.render.script;

import com.meti.render.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleStringRefTest {

    @Test
    void concat() {
        StringRef a = SimpleStringRef.of("a");
        StringRef b = SimpleStringRef.of("b");
        StringRef c = SimpleStringRef.of("c");
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
        Component value = SimpleStringRef.of("test");
        assertEquals("\"test\"", value.render());
    }
}