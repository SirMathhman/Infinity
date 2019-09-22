package com.meti.net.router;

import com.meti.net.Request;
import com.meti.net.response.Response;

public interface Router {
    Response process(Request request);
}
