package com.meti;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoWSD;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

class NanoServer implements Server {
    private final NanoWSD internalServer;

    NanoServer(int port, Router<Request, Response, Route<Request, Response>> httpRouter, Router<Frame, Message, ? extends SocketRoute> webSocketRouter) {
        this.internalServer = new InternalServer(port, httpRouter, webSocketRouter);
    }

    @Override
    public void start() throws IOException {
        internalServer.start();
    }

    @Override
    public void stop() {
        internalServer.stop();
    }

    private static class InternalServer extends NanoWSD {
        private final Router<Request, com.meti.Response, Route<Request, com.meti.Response>> httpRouter;
        private final Router<Frame, Message, ? extends SocketRoute> webSocketRouter;

        InternalServer(int port,
                       Router<Request, com.meti.Response, Route<Request, com.meti.Response>> httpRouter,
                       Router<Frame, Message, ? extends SocketRoute> webSocketRouter) {
            super(port);
            this.httpRouter = httpRouter;
            this.webSocketRouter = webSocketRouter;
        }

        @Override
        protected Response serveHttp(IHTTPSession session) {
            Request request = new SessionRequest(session);
            com.meti.Response response = httpRouter.route(request);
            Response.IStatus status = Response.Status.lookup(response.code().value());
            String type = response.type().value();
            InputStream stream = new ByteArrayInputStream(response.data());
            long length = response.data().length;
            return newFixedLengthResponse(status, type, stream, length);
        }

        @Override
        protected WebSocket openWebSocket(IHTTPSession handshake) {
            Request request = new SessionRequest(handshake);
            return new NanoServer.InternalSocket(handshake, request, webSocketRouter);
        }

    }

    private static class InternalSocket extends NanoWSD.WebSocket {
        private final Request request;
        private final Router<Frame, Message, ? extends SocketRoute> router;

        InternalSocket(NanoHTTPD.IHTTPSession handshake, Request request, Router<Frame, Message, ? extends SocketRoute> router) {
            super(handshake);
            this.router = router;
            this.request = request;
        }

        @Override
        protected void onOpen() {
            router.routes().forEach((Consumer<SocketRoute>) socketRoute -> socketRoute.open(request));
        }

        @Override
        protected void onClose(NanoWSD.WebSocketFrame.CloseCode code, String reason, boolean initiatedByRemote) {
            Close close = new FrameClose(code, reason, initiatedByRemote);
            router.routes().forEach((Consumer<SocketRoute>) messageRoute -> messageRoute.close(request, close));
        }

        @Override
        protected void onMessage(NanoWSD.WebSocketFrame message) {
            router.route(new NanoFrame(message));
        }

        @Override
        protected void onPong(NanoWSD.WebSocketFrame pong) {
            //TODO: do something?
        }

        @Override
        protected void onException(IOException exception) {
            //TODO: throw something somewhere
        }
    }
}
