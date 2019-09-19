package com.meti.response;

public enum ResponseCodes implements ResponseCode {
    OK(200),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500);

    private final int value;

    ResponseCodes(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
