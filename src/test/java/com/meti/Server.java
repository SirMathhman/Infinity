package com.meti;

import java.io.IOException;

interface Server {
    void start() throws IOException;

    void stop();
}
