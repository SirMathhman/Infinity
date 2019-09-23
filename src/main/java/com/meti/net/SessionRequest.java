package com.meti.net;

import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionRequest implements Request {
    private final NanoHTTPD.IHTTPSession session;

    SessionRequest(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }

    @Override
    public String getPath() {
        return session.getUri();
    }

    @Override
    public RequestBody parseRequestBody() throws IOException, NanoHTTPD.ResponseException {
        session.parseBody(new HashMap<>());
        return new SessionRequestBody(session);
    }

    @Override
    public Method getMethod() {
        return Method.valueOf(session.getMethod().name().toUpperCase());
    }

    private static class SessionRequestBody implements RequestBody {
        private final NanoHTTPD.IHTTPSession session;

        SessionRequestBody(NanoHTTPD.IHTTPSession session) {
            this.session = session;
        }

        @Override
        public Map<String, List<String>> getData() {
            return session.getParameters();
        }
    }
}
