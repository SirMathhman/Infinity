package com.meti.router;

import com.meti.Route;

public interface MutableRouter extends Router {
    <R extends Route> void with(R route);
}
