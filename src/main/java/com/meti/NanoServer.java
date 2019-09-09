package com.meti;

import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static fi.iki.elonen.NanoHTTPD.Response.Status.lookup;

class NanoServer implements Server {
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
        private static final int PORT = 80;
        private final Route route;

        InternalServer(Route route) {
            super(PORT);
            this.route = route;
        }

        @Override
        public Response serve(IHTTPSession session) {
            com.meti.Response response = route.process();
            return convertToNanoResponse(response);
        }

        private Response convertToNanoResponse(com.meti.Response response) {
            String contentType = response.getContentType();
            int responseCode = response.getResponseCode();
            Response.Status status = lookup(responseCode);
            ByteArrayInputStream stream = new ByteArrayInputStream(response.getData());
            int dataLength = response.getData().length;
            return newFixedLengthResponse(status, contentType,
                    stream, (long) dataLength);
        }
    }
}