package com.meti.net;

import com.meti.net.response.Response;

public interface Route {
    boolean canProcess(Request request);
    Response process();
}
