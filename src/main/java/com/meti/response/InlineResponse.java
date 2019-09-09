package com.meti.response;

public class InlineResponse implements Response {
    private final ResponseType responseType;
    private final byte[] data;
    private final ResponseCode responseCode;

    public InlineResponse(ResponseCode responseCode, ResponseType responseType, byte[] data) {
        this.responseCode = responseCode;
        this.responseType = responseType;
        this.data = data.clone();
    }

    @Override
    public String getResponseType() {
        return responseType.getValue();
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
