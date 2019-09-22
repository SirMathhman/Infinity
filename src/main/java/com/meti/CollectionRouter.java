package com.meti;

import java.util.Collection;
import java.util.NoSuchElementException;

class CollectionRouter implements Router {
    private final Collection<Route> routes;

    CollectionRouter(Collection<Route> routes) {
        this.routes = routes;
    }

    @Override
    public Response process(Request request) {
        return routes.stream()
                .filter(route -> route.canProcess(request))
                .map(Route::process)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
