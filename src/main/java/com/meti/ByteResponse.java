package com.meti;

class ByteResponse implements Response {
    private final ResponseCode code;
    private final ResponseType type;
    private final byte[] data;

    ByteResponse(ResponseCode code, ResponseType type, byte[] data) {
        this.code = code;
        this.type = type;
        this.data = data;
    }

    @Override
    public ResponseCode code() {
        return code;
    }

    @Override
    public ResponseType type() {
        return type;
    }

    @Override
    public byte[] data() {
        return data;
    }
}
