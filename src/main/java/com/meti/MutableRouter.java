package com.meti;

interface MutableRouter extends Router {
    <R extends Route> void with(R route);
}
