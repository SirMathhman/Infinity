package com.meti;

import com.meti.render.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringRefTest {

    @Test
    void of() {
        Component component = StringRef.of("test");
        assertEquals("\"test\"", component.render());
    }
}