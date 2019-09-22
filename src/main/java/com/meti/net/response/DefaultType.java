package com.meti.net.response;

public enum DefaultType implements ResponseType {
    PLAIN("text/plain"),
    HTML("text/html");

    private final String value;

    DefaultType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
