package com.meti;

import java.io.IOException;

public interface Server {
    void start() throws IOException;

    void stop();
}
