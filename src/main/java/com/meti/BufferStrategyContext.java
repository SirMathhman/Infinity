package com.meti;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Objects;

class BufferStrategyContext extends GraphicsContext {
    private final BufferStrategy bufferStrategy;

    public BufferStrategyContext(BufferStrategy bufferStrategy) {
        super(bufferStrategy.getDrawGraphics());
        Objects.requireNonNull(bufferStrategy);
        this.bufferStrategy = bufferStrategy;
    }

    @Override
    public void render(Image image) {
        super.render(image);
        if (shouldRerender()) render(image);
    }

    private boolean shouldRerender() {
        return bufferStrategy.contentsLost() || bufferStrategy.contentsRestored();
    }
}
