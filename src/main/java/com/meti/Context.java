package com.meti;

import java.awt.image.BufferStrategy;
import java.util.Objects;

class Context {
    private final BufferStrategy bufferStrategy;

    public Context(BufferStrategy bufferStrategy) {
        Objects.requireNonNull(bufferStrategy);
        this.bufferStrategy = bufferStrategy;
    }
}
