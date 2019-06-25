package com.meti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Frame frame;

    @BeforeEach
    void before(){
        this.frame = new Frame();
        this.frame.setSize(600, 400);
        this.frame.setTitle("Hello World");
        this.frame.setVisible(true);
    }

    @Test
    void size(){
        assertEquals(new Dimension(600, 400), frame.getSize());
    }

    @Test
    void title(){
        assertEquals("Hello World", frame.getTitle());
    }

    @Test
    void visible(){
        assertTrue(frame.isVisible());
    }
}
