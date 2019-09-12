package com.meti.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SimpleBindingTest {

    @Test
    void clear() {
        Binding<String> binding = new SimpleBinding<>("test");
        binding.clear();
        assertFalse(binding.getOptionally().isPresent());
    }

    @Test
    void get() {
        Binding<String> binding = new SimpleBinding<>("test");
        assertEquals("test", binding.get());
    }

    @Test
    void getOptionally() {
        assertFalse(new SimpleBinding<String>().getOptionally().isPresent());
    }

    @Test
    void set() {
        Binding<String> binding = new SimpleBinding<>();
        binding.set("test");
        assertEquals("test", binding.get());
    }
}