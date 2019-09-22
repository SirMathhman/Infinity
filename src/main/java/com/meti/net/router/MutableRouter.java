package com.meti.net.router;

import com.meti.net.Route;

public interface MutableRouter extends Router {
    <R extends Route> void with(R route);
}
