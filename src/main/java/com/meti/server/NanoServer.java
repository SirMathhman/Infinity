package com.meti.server;

import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NanoServer implements Server {
    private final NanoHTTPD internalServer;

    public NanoServer(int port, Router router) {
        this(new InternalServer(port, router));
    }

    public NanoServer(NanoHTTPD internalServer) {
        this.internalServer = internalServer;
    }

    public NanoHTTPD getInternalServer() {
        return internalServer;
    }

    @Override
    public void start() throws IOException {
        getInternalServer().start();
    }

    @Override
    public void stop() {
        getInternalServer().stop();
    }

    static class InternalServer extends NanoHTTPD {
        private final Router router;

        public InternalServer(int port, Router router) {
            super(port);
            this.router = router;
        }

        static Response toNanoResponse(com.meti.response.Response response) {
            return newFixedLengthResponse(Response.Status.lookup(response.getResponseCode().getValue()), response.getContentType().getValue(), new ByteArrayInputStream(response.getBytes()), response.getBytes().length);
        }

        @Override
        public Response serve(IHTTPSession session) {
            return toNanoResponse(router.process());
        }
    }
}
