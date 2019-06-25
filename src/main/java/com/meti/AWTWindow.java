package com.meti;

import java.awt.*;
import java.awt.image.BufferStrategy;

class AWTWindow implements Window {
    private final Frame frame = new Frame();

    AWTWindow(int width, int height, String title) {
        frame.setSize(width, height);
        frame.setTitle(title);
        frame.setVisible(true);
    }

    @Override
    public BufferStrategy getContext(int numBuffers) {
        frame.createBufferStrategy(numBuffers);
        return frame.getBufferStrategy();
    }
}