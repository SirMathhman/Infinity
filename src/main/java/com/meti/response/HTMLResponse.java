package com.meti.response;

import com.meti.render.Component;

public class HTMLResponse implements Response {
    private final Component root;
    private final ResponseCode responseCode;

    public HTMLResponse(ResponseCode responseCode, Component root) {
        this.responseCode = responseCode;
        this.root = root;
    }

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public ResponseType getContentType() {
        return ResponseTypes.HTML;
    }

    @Override
    public byte[] getBytes() {
        return root.render().getBytes();
    }
}
