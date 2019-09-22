package com.meti.router;

import com.meti.Request;
import com.meti.Response;
import com.meti.Route;

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