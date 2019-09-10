package com.meti.nano;

import com.meti.route.Router;
import com.meti.server.Server;
import com.meti.server.SimpleServerBuilder;
import fi.iki.elonen.NanoHTTPD;

public class NanoServerBuilder implements SimpleServerBuilder<NanoHTTPD.Response> {
    private static final int HTTP_PORT = 80;
    private final int port;
    private final Router<? extends NanoHTTPD.Response> router;

    public NanoServerBuilder() {
        this(HTTP_PORT, null);
    }

    private NanoServerBuilder(int port, Router<? extends NanoHTTPD.Response> router) {
        this.port = port;
        this.router = router;
    }

    @Override
    public Server build() {
        return new NanoServer(port, router);
    }

    @Override
    public SimpleServerBuilder<NanoHTTPD.Response> withPort(int port) {
        return new NanoServerBuilder(port, router);
    }

    @Override
    public SimpleServerBuilder<NanoHTTPD.Response> withRouter(Router<? extends NanoHTTPD.Response> router) {
        return new NanoServerBuilder(port, router);
    }
}