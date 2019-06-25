package com.meti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private static final Dimension EXPECTED_SIZE = new Dimension(600, 400);
    private static final String EXPECTED_TITLE = "Hello World";
    private final Frame frame = new Frame();

    @BeforeEach
    void before() {
        this.frame.setSize(EXPECTED_SIZE);
        this.frame.setTitle(EXPECTED_TITLE);
        this.frame.setVisible(true);
    }

    @Test
    void size() {
        Dimension frameSize = frame.getSize();
        assertEquals(EXPECTED_SIZE, frameSize);
    }

    @Test
    void title() {
        String frameTitle = frame.getTitle();
        assertEquals(EXPECTED_TITLE, frameTitle);
    }

    @Test
    void visible() {
        boolean frameVisible = frame.isVisible();
        assertTrue(frameVisible);
    }
}
