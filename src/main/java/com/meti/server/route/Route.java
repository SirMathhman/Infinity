package com.meti.server.route;

import com.meti.server.context.Request;
import com.meti.server.response.Response;

public interface Route {
    default boolean canProcess(Request request) {
        return true;
    }

    Response process(Request request);
}
