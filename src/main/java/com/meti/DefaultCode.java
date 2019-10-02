package com.meti;

enum DefaultCode implements ResponseCode {
    OK(200);
    private final int value;

    DefaultCode(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }
}
