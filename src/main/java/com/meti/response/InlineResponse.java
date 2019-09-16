package com.meti.response;

public class InlineResponse implements Response {
    private final ResponseCode responseCode;
    private final ResponseType contentType;
    private final byte[] bytes;

    public InlineResponse(ResponseCode responseCode, ResponseType contentType, byte[] bytes) {
        this.responseCode = responseCode;
        this.contentType = contentType;
        this.bytes = bytes;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public ResponseType getContentType() {
        return contentType;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }
}
