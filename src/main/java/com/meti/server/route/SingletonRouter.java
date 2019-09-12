package com.meti.server.route;

import com.meti.server.context.Request;
import com.meti.server.response.Response;

import java.util.NoSuchElementException;

public class SingletonRouter implements Router {
    private final Route route;

    public SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response route(Request request) {
        if (route.canProcess(request)) {
            return route.process(request);
        } else {
            throw new NoSuchElementException("Route cannot be applied to " + request.getPath());
        }
    }
}