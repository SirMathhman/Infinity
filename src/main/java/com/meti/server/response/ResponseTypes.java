package com.meti.server.response;

import fi.iki.elonen.NanoHTTPD;

import java.net.URI;
import java.nio.file.Path;

public final class ResponseTypes {
    private ResponseTypes() {
    }

    public static String get(Path path) {
        URI uri = path.toUri();
        String uriString = uri.toString();
        return NanoHTTPD.getMimeTypeForFile(uriString);
    }
}
