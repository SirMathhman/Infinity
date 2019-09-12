package com.meti.server;

import com.meti.server.context.Request;
import com.meti.server.context.SessionRequest;
import com.meti.server.response.ResponseCode;
import com.meti.server.route.Router;
import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NanoServer implements Server {
    private final NanoHTTPD internalServer;

    NanoServer(int port, Router router) {
        this.internalServer = new InternalServer(port, router);
    }

    @Override
    public void terminate() {
        this.internalServer.stop();
    }

    @Override
    public void run() throws IOException {
        internalServer.start();
    }

    private static class InternalServer extends NanoHTTPD {
        private final Router router;

        InternalServer(int port, Router router) {
            super(port);
            this.router = router;
        }

        @Override
        public Response serve(IHTTPSession session) {
            com.meti.server.response.Response response = route(new SessionRequest(session));
            ResponseCode responseCode = response.getResponseCode();
            String responseType = response.getType();
            byte[] responseData = response.getData();
            return buildResponse(responseCode, responseType, responseData);
        }

        private com.meti.server.response.Response route(Request request) {
            return router.route(request);
        }

        private Response buildResponse(ResponseCode responseCode, String type, byte[] bytes) {
            Response.Status nanoStatus = Response.Status.lookup(responseCode.getValue());
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            long streamLength = (long) bytes.length;
            return newFixedLengthResponse(nanoStatus, type, stream, streamLength);
        }
    }
}