package com.meti.server.route;

import com.meti.server.context.Context;
import com.meti.server.response.Response;

public interface Router {
    Response route(Context context);
}
