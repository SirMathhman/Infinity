package com.meti;

import com.meti.server.context.Context;
import com.meti.server.response.Response;
import com.meti.server.route.Route;
import com.meti.server.route.Router;

import java.util.Collection;
import java.util.Collections;

public class CollectionRouter implements Router {
    private final Collection<? extends Route> routes;

    CollectionRouter(Collection<? extends Route> routes) {
        this.routes = Collections.unmodifiableCollection(routes);
    }

    @Override
    public Response route(Context context) {
        return routes.stream()
                .filter(route -> route.canProcess(context))
                .findAny()
                .orElseThrow()
                .process();
    }
}
