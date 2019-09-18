package com.meti.server;

import com.meti.response.Response;

public class SingletonRouter implements Router {
    private final Route route;

    public SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response process() {
        return route.process();
    }
}