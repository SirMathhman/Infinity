package com.meti;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

class NanoServer implements Server {
    private static final int PORT = 80;
    private final NanoHTTPD internalServer;

    NanoServer(Route route) {
        internalServer = new InternalServer(route);
    }

    @Override
    public void start() throws IOException {
        internalServer.start();
    }

    @Override
    public void stop() {
        internalServer.stop();
    }

    private static class InternalServer extends NanoHTTPD {
        private final Route route;

        InternalServer(Route route) {
            super(PORT);
            this.route = route;
        }

        @Override
        public Response serve(IHTTPSession session) {
            return route.processToNano();
        }
    }
}