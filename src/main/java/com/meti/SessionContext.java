package com.meti;

import fi.iki.elonen.NanoHTTPD;

public class SessionContext implements Context {
    private final NanoHTTPD.IHTTPSession session;

    SessionContext(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }

    @Override
    public String getPath() {
        return session.getUri();
    }
}
