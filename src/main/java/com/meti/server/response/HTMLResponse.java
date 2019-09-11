package com.meti.server.response;

import com.meti.render.Component;

public class HTMLResponse extends StringResponse {
    public HTMLResponse(ResponseCode responseCode, Component component) {
        this(responseCode, component.render());
    }

    public HTMLResponse(ResponseCode responseCode, String value) {
        super(value, responseCode, "text/html");
    }
}
