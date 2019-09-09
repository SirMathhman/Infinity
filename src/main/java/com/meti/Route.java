package com.meti;

import fi.iki.elonen.NanoHTTPD;

public interface Route {
    Response process();

    default NanoHTTPD.Response processToNano() {
        Response response = process();
        return response.toNanoResponse();
    }
}
