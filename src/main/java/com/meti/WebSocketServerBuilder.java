package com.meti;

interface WebSocketServerBuilder extends ServerBuilder {
    ServerBuilder withWebSocketRouter(Router<Frame, Message, SocketRoute> webSocketRouter);
}
