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
    public ContentType getContentType() {
        return ContentTypes.PLAINTEXT;
    }

    @Override
    public byte[] getBytes() {
        return value.getBytes();
    }
}
