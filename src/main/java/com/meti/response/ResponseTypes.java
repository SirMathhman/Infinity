package com.meti.response;

import fi.iki.elonen.NanoHTTPD;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public class ResponseTypes implements ResponseType {
    public static final ResponseType PLAINTEXT = new ResponseTypes("text/plain");
    static final ResponseType HTML = new ResponseTypes("text/html");
    private final String value;

    public ResponseTypes(String value) {
        this.value = value;
    }

    public static ResponseType fromPath(Path path) throws MalformedURLException {
        URI uri = path.toUri();
        URL url = uri.toURL();
        String urlString = url.toString();
        String mimeType = NanoHTTPD.getMimeTypeForFile(urlString);
        return new ResponseTypes(mimeType);
    }

    @Override
    public String getValue() {
        return value;
    }
}
