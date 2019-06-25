package com.meti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StrategyTest {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private final Frame frame = new Frame();

    @BeforeEach
    void before() {
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setTitle("Hello World");
        this.frame.setVisible(true);
    }

    @Test
    void strategyPresent() {
        frame.createBufferStrategy(3);
        BufferStrategy bufferStrategy = frame.getBufferStrategy();
        assertNotNull(bufferStrategy);
    }
}
