package com.meti;

import static java.nio.charset.StandardCharsets.UTF_8;

class StringResponse implements Response {
    private final ResponseCode responseCode;
    private final String type;
    private final String value;

    StringResponse(ResponseCode responseCode, String value) {
        this(value, responseCode, "text/plain");
    }

    StringResponse(String value, ResponseCode responseCode, String type) {
        this.value = value;
        this.responseCode = responseCode;
        this.type = type;
    }

    @Override
    public byte[] getData() {
        return value.getBytes(UTF_8);
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public String getType() {
        return type;
    }
}
