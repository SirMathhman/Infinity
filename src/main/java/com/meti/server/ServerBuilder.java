package com.meti.server;

import com.meti.route.Router;

import java.io.IOException;

public interface ServerBuilder<S extends ServerBuilder<S, R>, R> {
    Server build() throws IOException;

    S withPort(int port);

    S withRouter(Router<? extends R> router);
}
