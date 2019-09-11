package com.meti.server.route;

import com.meti.server.context.Context;
import com.meti.server.response.Response;

import java.util.NoSuchElementException;

public class SingletonRouter implements Router {
    private final Route route;

    public SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response route(Context context) {
        if (route.canProcess(context)) {
            return route.process(context);
        } else {
            throw new NoSuchElementException("Route cannot be applied to " + context.getPath());
        }
    }
}