package com.meti.router;

import com.meti.Request;
import com.meti.Response;
import com.meti.Route;

import java.util.Collection;
import java.util.NoSuchElementException;

public class CollectionRouter implements Router {
    private final Collection<Route> routes;

    public CollectionRouter(Collection<Route> routes) {
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
