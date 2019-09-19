package com.meti.server;

import com.meti.response.Response;

import java.util.NoSuchElementException;

public class SingletonRouter implements Router {
    private final Route route;

    public SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response process(Context context) {
        if (route.canProcess(context)) {
            return route.process(context);
        } else {
            throw new NoSuchElementException("Route supplied is not valid.");
        }
    }

}