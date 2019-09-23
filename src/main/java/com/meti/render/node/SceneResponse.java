package com.meti.render.node;

import com.meti.net.response.Response;
import com.meti.net.response.ResponseCode;
import com.meti.net.response.ResponseType;

public class SceneResponse implements Response {
    private final ResponseCode responseCode;
    private final ResponseType responseType;
    private final Node node;

    public SceneResponse(ResponseCode responseCode, ResponseType responseType, Node node) {
        this.responseCode = responseCode;
        this.responseType = responseType;
        this.node = node;
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
        return node.render().render().getBytes();
    }
}
