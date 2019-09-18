package com.meti.server;

import com.meti.response.ResponseCode;
import com.meti.response.ResponseType;
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
            ResponseCode responseCode = response.getResponseCode();
            ResponseType contentType = response.getContentType();
            byte[] data = response.getBytes();
            return newFixedLengthResponse(Response.Status.lookup(responseCode.getValue()),
                    contentType.getValue(), new ByteArrayInputStream(data), data.length);
        }

        @Override
        public Response serve(IHTTPSession session) {
            return toNanoResponse(router.process());
        }
    }
}
