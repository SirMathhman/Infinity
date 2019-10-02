package com.meti;

interface ServerBuilder {
    ServerBuilder withPort(int port);

    ServerBuilder withHTTPRouter(Router<Request, Response, Route<Request, Response>> httpRouter);

    Server build();
}
