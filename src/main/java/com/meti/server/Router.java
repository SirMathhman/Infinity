package com.meti.server;

import com.meti.response.Response;

public interface Router {
    Response process(Context context);
}
