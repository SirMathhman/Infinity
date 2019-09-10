package com.meti.response;

import java.nio.charset.StandardCharsets;

public class StringResponse implements Response {
    private final String content;
    private final int responseCode;

    public StringResponse() {
        this.responseCode = -1;
        this.content = "test";
    }

    @Override
    public byte[] getContentBytes() {
        return content.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public int getResponseCode() {
        return responseCode;
    }
}
