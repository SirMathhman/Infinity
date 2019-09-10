package com.meti.http;

import com.meti.server.Server;
import com.meti.response.Response;
import com.meti.route.Router;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;

class HTTPServer implements Server {
    private final HttpServer server;

    HTTPServer(HttpServer server, Router<? extends Response> router) {
        this.server = server;
        server.createContext("/", new InternalHandler(router));
    }

    @Override
    public void start() {
        server.start();
    }

    @Override
    public void stop() {
        server.stop(0);
    }

    private static final class InternalHandler implements HttpHandler {
        private final Router<? extends Response> router;

        private InternalHandler(Router<? extends Response> router) {
            this.router = router;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            write(exchange, router.process());
        }

        private void write(HttpExchange exchange, Response response) throws IOException {
            exchange.sendResponseHeaders(response.getResponseCode(), (long) response.getContentBytes().length);
            try (OutputStream responseBody = exchange.getResponseBody()) {
                responseBody.write(response.getContentBytes());
                responseBody.flush();
            }
        }
    }
}
