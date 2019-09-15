package com.meti;

public class Router {
    private final Route route;

    public Router(Route route) {
        this.route = route;
    }

    public Response process() {
        return route.process();
    }
}