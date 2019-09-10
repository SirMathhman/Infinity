package com.meti.server;

import com.meti.server.route.Router;

public class NanoServerBuilder implements ServerBuilder {
    private static final int HTTP_PORT = 80;
    private final int port;
    private final Router router;

    public NanoServerBuilder() {
        this(HTTP_PORT, null);
    }

    private NanoServerBuilder(int port, Router router) {
        this.port = port;
        this.router = router;
    }

    @Override
    public Server build() {
        return new NanoServer(port, router);
    }

    @Override
    public ServerBuilder withRouter(Router router) {
        return new NanoServerBuilder(port, router);
    }
}