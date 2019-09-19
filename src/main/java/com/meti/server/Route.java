package com.meti.server;

import com.meti.response.Response;

public interface Route {
    Response process(Context context);

    default boolean canProcess(Context context) {
        return true;
    }
}
