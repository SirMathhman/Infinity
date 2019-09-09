package com.meti;

public class InlineResponse implements Response {
    private final ContentType contentType;
    private final byte[] data;
    private final ResponseCode responseCode;

    InlineResponse(ResponseCode responseCode, ContentType contentType, byte[] data) {
        this.responseCode = responseCode;
        this.contentType = contentType;
        this.data = data.clone();
    }

    @Override
    public String getContentType() {
        return contentType.getValue();
    }

    @Override
    public byte[] getData() {
        return data.clone();
    }

    @Override
    public int getResponseCode() {
        return responseCode.getValue();
    }
}
