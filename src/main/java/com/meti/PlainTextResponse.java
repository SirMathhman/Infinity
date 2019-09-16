package com.meti;

public class PlainTextResponse implements Response {
    private String value;

    public PlainTextResponse(String value) {
        this.value = value;
    }

    @Override
    public ResponseCodes getResponseCode() {
        return ResponseCodes.OK;
    }

    @Override
    public ResponseType getContentType() {
        return ResponseTypes.PLAINTEXT;
    }

    @Override
    public byte[] getBytes() {
        return value.getBytes();
    }
}
