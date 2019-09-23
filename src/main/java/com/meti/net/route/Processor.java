package com.meti.net.route;

import com.meti.net.Request;
import com.meti.net.response.Response;

public interface Processor {
    Response process(Request request);
}
