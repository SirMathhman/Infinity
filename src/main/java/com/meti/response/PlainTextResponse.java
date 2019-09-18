package com.meti.response;

import java.nio.charset.StandardCharsets;

public class PlainTextResponse implements Response {
    private final String value;

    public PlainTextResponse(String value) {
        this.value = value;
    }

    @Override
    public ResponseCode getResponseCode() {
        return ResponseCodes.OK;
    }

    @Override
    public ResponseType getContentType() {
        return ResponseTypes.PLAINTEXT;
    }

    @Override
    public byte[] getBytes() {
        return value.getBytes(StandardCharsets.UTF_8);
    }
}
