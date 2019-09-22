package com.meti.net.response;

public enum DefaultCode implements ResponseCode {
    OK(200), BAD_REQUEST(400);
    private final int value;

    DefaultCode(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}