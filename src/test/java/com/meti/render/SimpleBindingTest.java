package com.meti.render;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SimpleBindingTest {

    @Test
    void get() {
        Binding<String> binding = new SimpleBinding<>("some");
        assertEquals("some", binding.get());
    }

    @Test
    void getOptionally() {
        Binding<String> binding = new SimpleBinding<>(null);
        assertFalse(binding.getOptionally().isPresent());
    }

    @Test
    void with() {
        Binding<String> parent = new SimpleBinding<>("foo");
        Binding<String> child = parent.with("bar");
        assertEquals("bar", child.get());
    }

    @Test
    void compute() {
        Binding<String> parent = new SimpleBinding<>("5");
        Binding<Integer> child = parent.compute(Integer::parseInt);
        assertEquals(5, child.get());
    }
}