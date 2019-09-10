package com.meti.http;

import com.meti.server.Server;
import com.meti.server.ServerBuilder;
import com.meti.response.Response;
import com.meti.route.Router;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HTTPServerBuilder implements QueueServerBuilder {
    private static final int HTTP_PORT = 80;
    private static final int SYSTEM_BACKLOG = -1;
    private final int backlog;
    private final int port;
    private final Router<? extends Response> router;

    public HTTPServerBuilder() {
        this(SYSTEM_BACKLOG, HTTP_PORT, null);
    }

    private HTTPServerBuilder(int backlog, int port, Router<? extends Response> router) {
        this.backlog = backlog;
        this.port = port;
        this.router = router;
    }

    @Override
    public Server build() throws IOException {
        InetSocketAddress address = new InetSocketAddress(port);
        HttpServer internalServer = HttpServer.create(address, backlog);
        return new HTTPServer(internalServer, router);
    }

    @Override
    public QueueServerBuilder withPort(int port) {
        return new HTTPServerBuilder(backlog, port, router);
    }

    @Override
    public QueueServerBuilder withRouter(Router<? extends Response> router) {
        return new HTTPServerBuilder(backlog, port, router);
    }

    @Override
    public ServerBuilder<QueueServerBuilder, Response> withBacklog(int backlog) {
        return new HTTPServerBuilder(backlog, port, router);
    }
}