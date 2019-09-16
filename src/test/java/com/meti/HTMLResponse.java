package com.meti;

import com.meti.response.Response;
import com.meti.response.ResponseCode;
import com.meti.response.ResponseType;
import com.meti.response.ResponseTypes;

class HTMLResponse implements Response {
    private final Component root;
    private final ResponseCode responseCode;

    HTMLResponse(ResponseCode responseCode, Component root) {
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
