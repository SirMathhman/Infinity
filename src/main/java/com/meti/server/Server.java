package com.meti.server;

import java.io.IOException;

public interface Server extends AutoCloseable {
    @Override
    default void close() {
        terminate();
    }

    void terminate();

    void run() throws IOException;
}
