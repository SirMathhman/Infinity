package com.meti;

import com.meti.server.Route;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

abstract class SetParentRoute implements MutableParentRoute {
    private final Set<ParentRoute> routes = new HashSet<>();

    @Override
    public ParentRoute with(ParentRoute route) {
        boolean alreadyPresent = routes.stream().anyMatch(parentRoute -> samePath(route, parentRoute));
        if (!alreadyPresent) routes.add(route);
        return route;
    }

    private boolean samePath(ParentRoute route, ParentRoute parentRoute) {
        return parentRoute.getPath().equals(route.getPath());
    }

    @Override
    public Collection<? extends Route> getChildren() {
        return routes;
    }
}
