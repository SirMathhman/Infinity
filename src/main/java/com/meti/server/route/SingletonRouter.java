package com.meti.server.route;

import com.meti.server.context.Context;
import com.meti.server.response.Response;

public class SingletonRouter implements Router {
    private final Route route;

    public SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response route(Context context) {
        return route.process();
    }
}