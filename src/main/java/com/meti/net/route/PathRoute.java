package com.meti.net.route;

import com.meti.net.Request;

public interface PathRoute extends Route {
    @Override
    default boolean canProcess(Request request) {
        return request.getPath().equals(getPath());
    }

    String getPath();
}
