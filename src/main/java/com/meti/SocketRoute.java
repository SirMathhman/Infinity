package com.meti;

interface SocketRoute extends Route<Frame, Message> {
    void open(Request request);

    void close(Request request, Close close);
}
