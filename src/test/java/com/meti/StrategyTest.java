package com.meti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StrategyTest {
    private Frame frame;

    @BeforeEach
    void before() {
        this.frame = new Frame();
        this.frame.setSize(600, 400);
        this.frame.setTitle("Hello World");
        this.frame.setVisible(true);
    }

    @Test
    void strategyPresent() {
        frame.createBufferStrategy(3);
        assertNotNull(frame.getBufferStrategy());
    }
}
