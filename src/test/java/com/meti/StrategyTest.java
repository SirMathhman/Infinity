package com.meti;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.awt.image.BufferStrategy;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StrategyTest {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final String TITLE = "Hello World";
    private final Window window = new AWTWindow(WIDTH, HEIGHT, TITLE);

    @Test
    void strategyPresent() {
        assertDoesNotThrow(() -> {
            window.getContext(3);
        });
    }
}
