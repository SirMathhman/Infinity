package com.meti.render.scene.style;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleDimensionsTest {

    @Test
    void height() {
        Constraint width = new PixelConstraint(5);
        Constraint height = new PixelConstraint(10);
        Dimensions dimensions = new SimpleDimensions(width, height);
        assertEquals(height, dimensions.height().get());
    }

    @Test
    void set() {
        Dimensions dimensions = new SimpleDimensions();
        Constraint width = new PixelConstraint(5);
        Constraint height = new PixelConstraint(10);
        dimensions.set(width, height);
        assertEquals(width, dimensions.width().get());
        assertEquals(height, dimensions.height().get());
    }

    @Test
    void width() {
        Constraint width = new PixelConstraint(5);
        Constraint height = new PixelConstraint(10);
        Dimensions dimensions = new SimpleDimensions(width, height);
        assertEquals(width, dimensions.width().get());
    }
}