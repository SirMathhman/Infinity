package com.meti.net.route;

import com.meti.net.Request;
import com.meti.net.response.Response;

public interface Route {
    boolean canProcess(Request request);

    Response process(Request request);
}
