package com.meti.net;

import com.meti.net.router.Router;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NanoServer implements Server {
    private final NanoHTTPD server;

    public NanoServer(int port, Router router) {
        this(new InternalServer(port, router));
    }

    private NanoServer(NanoHTTPD server) {
        this.server = server;
    }

    @Override
    public void start() throws IOException {
        server.start();
    }

    @Override
    public void stop() {
        server.stop();
    }

    static class InternalServer extends NanoHTTPD {
        private final Router router;

        InternalServer(int port, Router router) {
            super(port);
            this.router = router;
        }

        @Override
        public Response serve(IHTTPSession session) {
            return serveOther(new SessionRequest(session));
        }

        private Response serveOther(Request request) {
            return toNanoResponse(router.process(request));
        }

        private Response toNanoResponse(com.meti.net.response.Response response) {
            InputStream inputStream = new ByteArrayInputStream(response.getBytes());
            return newFixedLengthResponse(Status.lookup(
                    response.getResponseCode().getValue()), response.getResponseType().getValue(),
                    inputStream,
                    response.getBytes().length);
        }
    }
}
