package com.meti.nano;

import com.meti.server.Server;
import com.meti.route.Router;
import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

public class NanoServer implements Server {
    private final int port;
    private final Router<? extends NanoHTTPD.Response> router;
    private NanoHTTPD internalServer = null;

    NanoServer(int port, Router<? extends NanoHTTPD.Response> router) {
        this.port = port;
        this.router = router;
    }

    @Override
    public void start() throws IOException {
        internalServer = new InternalServer(this.port, router);
        internalServer.start();
    }

    @Override
    public void stop() {
        internalServer.stop();
    }

    private static final class InternalServer extends NanoHTTPD {
        private final Router<? extends Response> router;

        private InternalServer(int port, Router<? extends Response> router) {
            super(port);
            this.router = router;
        }

        @Override
        public Response serve(IHTTPSession session) {
            return router.process();
        }
    }
}