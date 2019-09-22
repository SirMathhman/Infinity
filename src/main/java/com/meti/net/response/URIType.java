package com.meti.net.response;

import fi.iki.elonen.NanoHTTPD;

import java.net.URI;

public class URIType implements ResponseType {
    private final URI uri;

    public URIType(URI uri) {
        this.uri = uri;
    }

    @Override
    public String getValue() {
        return NanoHTTPD.getMimeTypeForFile(uri.toString());
    }
}
