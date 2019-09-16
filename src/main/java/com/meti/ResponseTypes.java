package com.meti;

public class ResponseTypes implements ResponseType {
    public static final ResponseType PLAINTEXT = new ResponseTypes("text/plain");
    public static final ResponseType HTML = new ResponseTypes("text/html");
    private final String contentType;

    public ResponseTypes(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getValue() {
        return contentType;
    }
}
