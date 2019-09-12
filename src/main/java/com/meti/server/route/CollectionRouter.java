package com.meti.server.route;

import com.meti.server.context.Request;
import com.meti.server.response.Response;

import java.util.Collection;
import java.util.Collections;

public class CollectionRouter implements Router {
    private final Collection<? extends Route> routes;

    public CollectionRouter(Collection<? extends Route> routes) {
        this.routes = Collections.unmodifiableCollection(routes);
    }

    @Override
    public Response route(Request request) {
        return routes.stream()
                .filter(route -> route.canProcess(request))
                .findAny()
                .orElseThrow()
                .process(request);
    }
}
