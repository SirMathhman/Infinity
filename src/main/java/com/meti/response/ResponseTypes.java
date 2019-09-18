package com.meti.response;

public class ResponseTypes implements ResponseType {
    public static final ResponseType PLAINTEXT = new ResponseTypes("text/plain");
    static final ResponseType HTML = new ResponseTypes("text/html");
    private final String value;

    public ResponseTypes(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
