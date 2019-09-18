package com.meti.server;

import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NanoServer implements Server {
    private final NanoHTTPD internalServer;

    public NanoServer(int port, Router router) {
        this(new InternalServer(port, router));
    }

    private NanoServer(NanoHTTPD internalServer) {
        this.internalServer = internalServer;
    }

    @Override
    public void start() throws IOException {
        internalServer.start();
    }

    @Override
    public void stop() {
        internalServer.stop();
    }

    private static final class InternalServer extends NanoHTTPD {
        private final Router router;

        private InternalServer(int port, Router router) {
            super(port);
            this.router = router;
        }

        static Response toNanoResponse(com.meti.response.Response response) {
            return newFixedLengthResponse(Response.Status.lookup(response.getResponseCode().getValue()),
                    response.getContentType().getValue(), new ByteArrayInputStream(response.getBytes()),
                    (long) response.getBytes().length);
        }

        @Override
        public Response serve(IHTTPSession session) {
            return toNanoResponse(router.process());
        }
    }
}
