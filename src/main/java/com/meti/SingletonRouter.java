package com.meti;

public class SingletonRouter implements Router {
    private final Route route;

    SingletonRouter(Route route) {
        this.route = route;
    }

    @Override
    public Response route(Context context) {
        return route.process();
    }
}