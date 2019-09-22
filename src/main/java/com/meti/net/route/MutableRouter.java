package com.meti.net.route;

public interface MutableRouter extends Router {
    <R extends Route> void with(R route);
}
