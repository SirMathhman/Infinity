package com.meti.server.context;

import fi.iki.elonen.NanoHTTPD;

public class SessionRequest implements Request {
    private final NanoHTTPD.IHTTPSession session;

    public SessionRequest(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }

    @Override
    public String getPath() {
        return session.getUri();
    }
}
