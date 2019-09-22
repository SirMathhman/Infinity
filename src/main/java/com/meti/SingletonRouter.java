package com.meti;

public class SingletonRouter implements Router {
    private final Route route;

    SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response process() {
        return route.process();
    }
}