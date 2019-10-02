package com.meti;

import java.util.Collection;

import static java.util.Collections.singleton;

class SingletonRouter<I, O, R extends Route<I, O>> implements Router<I, O, R> {
    private final R route;

    SingletonRouter(R route) {
        this.route = route;
    }

    @Override
    public O route(I input) {
        return route.process(input);
    }

    @Override
    public Collection<? extends R> routes() {
        return singleton(route);
    }

    @Override
    public O process(I input) {
        if (route.canProcess(input)) {
            return route.process(input);
        } else {
            throw new IllegalArgumentException("Could not process input: " + input);
        }
    }
}
