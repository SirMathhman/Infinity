package com.meti;

import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class NanoServer implements Server {
    private final NanoHTTPD internalServer;

    NanoServer(int port, Router router) {
        this.internalServer = new InternalServer(port, router);
    }

    @Override
    public void start() throws IOException {
        internalServer.start();
    }

    @Override
    public void stop() {
        this.internalServer.stop();
    }

    private static class InternalServer extends NanoHTTPD {
        private final Router router;

        InternalServer(int port, Router router) {
            super(port);
            this.router = router;
        }

        @Override
        public Response serve(IHTTPSession session) {
            com.meti.Response response = route(new SessionContext(session));
            ResponseCode responseCode = response.getResponseCode();
            String responseType = response.getType();
            byte[] responseData = response.getData();
            return buildResponse(responseCode, responseType, responseData);
        }

        private com.meti.Response route(Context context) {
            return router.route(context);
        }

        private Response buildResponse(ResponseCode responseCode, String type, byte[] bytes) {
            Response.Status nanoStatus = Response.Status.lookup(responseCode.getValue());
            ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
            long streamLength = (long) bytes.length;
            return newFixedLengthResponse(nanoStatus, type, stream, streamLength);
        }
    }
}