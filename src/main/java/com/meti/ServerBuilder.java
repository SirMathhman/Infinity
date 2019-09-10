package com.meti;

public interface ServerBuilder {
    Server build();

    ServerBuilder withRouter(Router router);
}
