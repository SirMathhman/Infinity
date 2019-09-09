package com.meti;

public class InlineResponse implements Response {
    private final ResponseCode responseCode;
    private final ContentType contentType;
    private final byte[] data;

    InlineResponse(ResponseCode responseCode, ContentType contentType, byte[] data) {
        this.responseCode = responseCode;
        this.contentType = contentType;
        this.data = data.clone();
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
    public byte[] getData() {
        return data.clone();
    }
}
