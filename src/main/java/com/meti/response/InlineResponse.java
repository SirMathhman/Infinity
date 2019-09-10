package com.meti.response;

public class InlineResponse implements Response {
    private final byte[] contentBytes;
    private final int responseCode;

    public InlineResponse(int responseCode, byte[] contentBytes) {
        this.contentBytes = contentBytes.clone();
        this.responseCode = responseCode;
    }

    @Override
    public byte[] getContentBytes() {
        return contentBytes.clone();
    }

    @Override
    public int getResponseCode() {
        return responseCode;
    }
}
