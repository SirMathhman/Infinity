package com.meti.example;

import com.meti.server.response.Response;
import com.meti.server.response.ResponseCode;
import com.meti.server.response.ResponseCodes;

class SceneResponse implements Response {
    public SceneResponse(ResponseCodes responseCode, Scene scene) {
    }

    @Override
    public byte[] getData() {
        return new byte[0];
    }

    @Override
    public ResponseCode getResponseCode() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
