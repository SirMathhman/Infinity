package com.meti.server.response;

public class InlineResponse implements Response {
    private final byte[] bytes;
    private final String type;
    private final ResponseCode responseCode;

    public InlineResponse(byte[] bytes, String type, ResponseCode responseCode) {
        this.bytes = bytes.clone();
        this.type = type;
        this.responseCode = responseCode;
    }

    @Override
    public byte[] getData() {
        return bytes.clone();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
