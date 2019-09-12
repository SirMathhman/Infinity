package com.meti.server.route;

import com.meti.server.context.Request;
import com.meti.server.response.Response;

public interface Router {
    Response route(Request request);
}
