package com.meti.net;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

public interface Request {
    String getPath();

    RequestBody parseRequestBody() throws IOException, NanoHTTPD.ResponseException;

    Method getMethod();
}
