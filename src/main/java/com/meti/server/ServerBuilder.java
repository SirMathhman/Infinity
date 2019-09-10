package com.meti.server;

import com.meti.server.route.Router;

public interface ServerBuilder {
    Server build();

    ServerBuilder withRouter(Router router);
}
