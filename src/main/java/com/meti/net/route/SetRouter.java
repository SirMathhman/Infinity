package com.meti.net.route;

import com.meti.net.Request;
import com.meti.net.response.Response;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class SetRouter implements MutableRouter {
    private final Set<Route> routes = new HashSet<>();

    @Override
    public <R extends Route> void with(R route) {
        routes.add(route);
    }

    @Override
    public Response process(Request request) {
        return routes.stream()
                .filter(route -> route.canProcess(request))
                .map(route1 -> route1.process(request))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
