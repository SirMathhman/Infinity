package com.meti.net.router;

import com.meti.net.Request;
import com.meti.net.Route;
import com.meti.net.response.Response;

public class SingletonRouter implements Router {
    private final Route route;

    public SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response process(Request request) {
        return route.process();
    }
}