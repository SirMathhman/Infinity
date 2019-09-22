package com.meti.net.router;

import com.meti.net.Request;
import com.meti.net.Route;
import com.meti.net.response.Response;

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
