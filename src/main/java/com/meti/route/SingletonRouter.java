package com.meti.route;

public class SingletonRouter<T> implements Router<T> {
    private final Route<? extends T> route;

    public SingletonRouter(Route<? extends T> route) {
        this.route = route;
    }

    @Override
    public T process() {
        return route.process();
    }
}
