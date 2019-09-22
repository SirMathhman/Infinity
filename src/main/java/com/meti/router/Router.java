package com.meti.router;

import com.meti.Request;
import com.meti.Response;

public interface Router {
    Response process(Request request);
}
