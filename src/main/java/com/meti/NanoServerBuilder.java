package com.meti;

public class NanoServerBuilder implements WebSocketServerBuilder {
    private int port;
    private Router<Request, Response, Route<Request, Response>> httpRouter;
    private Router<Frame, Message, SocketRoute> webSocketRouter;

    @Override
    public ServerBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public ServerBuilder withHTTPRouter(Router<Request, Response, Route<Request, Response>> httpRouter) {
        this.httpRouter = httpRouter;
        return this;
    }

    @Override
    public ServerBuilder withWebSocketRouter(Router<Frame, Message, SocketRoute> webSocketRouter) {
        this.webSocketRouter = webSocketRouter;
        return this;
    }

    @Override
    public Server build() {
        return new NanoServer(port, httpRouter, webSocketRouter);
    }
}