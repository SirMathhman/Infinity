package com.meti.response;

public class HTMLType implements ResponseType {
    @Override
    public String getValue() {
        return "text/html";
    }
}