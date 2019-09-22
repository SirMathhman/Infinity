package com.meti.net.response;

public class ByteResponse implements Response {
    private final ResponseCode responseCode;
    private final ResponseType responseType;
    private final byte[] bytes;

    public ByteResponse(ResponseCode responseCode, ResponseType responseType, byte[] bytes) {
        this.responseCode = responseCode;
        this.responseType = responseType;
        this.bytes = bytes;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public ResponseType getResponseType() {
        return responseType;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }
}
