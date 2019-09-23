package com.meti.render.script;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleGeneratorTest {

    @Test
    void next() {
        Generator generator = new SimpleGenerator();
        assertEquals("a0", generator.next());
        assertEquals("b1", generator.next());
        assertEquals("c2", generator.next());
    }
}