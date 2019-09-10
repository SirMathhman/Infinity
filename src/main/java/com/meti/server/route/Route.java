package com.meti.server.route;

import com.meti.server.context.Context;
import com.meti.server.response.Response;

public interface Route {
    default boolean canProcess(Context context) {
        return true;
    }

    Response process();
}
