package com.meti.render.scene.style;

import com.meti.render.Component;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PixelConstraintTest {

    @Test
    void render() {
        Component constraint = new PixelConstraint(10);
        assertEquals("10px", constraint.render());
    }
}