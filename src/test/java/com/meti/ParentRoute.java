package com.meti;

import com.meti.server.Route;

import java.util.Collection;
import java.util.HashSet;

interface ParentRoute extends Route {
    static Collection<Route> collect(ParentRoute route) {
        route.onCollect();
        Collection<Route> routes = new HashSet<>();
        routes.add(route);
        for (Route child : route.getChildren()) {
            if (child instanceof ParentRoute) {
                routes.addAll(collect((ParentRoute) child));
            } else routes.add(child);
        }
        return routes;
    }

    default void onCollect() {
    }

    String getPath();

    Collection<? extends Route> getChildren();
}
