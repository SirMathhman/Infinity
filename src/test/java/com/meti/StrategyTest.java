package com.meti;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferStrategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StrategyTest {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final String TITLE = "Hello World";
    private final Window window = new AWTWindow(WIDTH, HEIGHT, TITLE);

    @Test
    void strategyPresent() {
        BufferStrategy bufferStrategy = window.getContext(3);
        assertNotNull(bufferStrategy);
    }
}
