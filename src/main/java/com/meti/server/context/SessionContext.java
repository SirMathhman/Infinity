package com.meti.server.context;

import fi.iki.elonen.NanoHTTPD;

public class SessionContext implements Context {
    private final NanoHTTPD.IHTTPSession session;

    public SessionContext(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }

    @Override
    public String getPath() {
        return session.getUri();
    }
}
