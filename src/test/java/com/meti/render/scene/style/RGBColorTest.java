package com.meti.render.scene.style;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RGBColorTest {

    @Test
    void render() {
        Color red = RGBColors.RED;
        assertEquals("rgb(255,0,0)", red.render());
    }
}