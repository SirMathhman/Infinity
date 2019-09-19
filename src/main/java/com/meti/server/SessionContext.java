package com.meti.server;

import fi.iki.elonen.NanoHTTPD;

class SessionContext implements Context {
    private final NanoHTTPD.IHTTPSession session;

    SessionContext(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }

    @Override
    public String getPath() {
        return session.getUri();
    }
}
