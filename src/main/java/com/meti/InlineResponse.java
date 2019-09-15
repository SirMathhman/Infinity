package com.meti;

public class InlineResponse implements Response {
    private final ResponseCode responseCode;
    private final ContentType contentType;
    private final byte[] bytes;

    public InlineResponse(ResponseCode responseCode, ContentType contentType, byte[] bytes) {
        this.responseCode = responseCode;
        this.contentType = contentType;
        this.bytes = bytes;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public ContentType getContentType() {
        return contentType;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }
}
