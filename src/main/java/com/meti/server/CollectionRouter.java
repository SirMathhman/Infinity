package com.meti.server;

import com.meti.response.Response;

import java.util.Collection;
import java.util.NoSuchElementException;

public class CollectionRouter implements Router {
    private final Collection<Route> routes;

    public CollectionRouter(Collection<Route> routes) {
        this.routes = routes;
    }

    @Override
    public Response process(Context context) {
        return routes.stream()
                .filter(route -> route.canProcess(context))
                .map(route -> route.process(context))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
