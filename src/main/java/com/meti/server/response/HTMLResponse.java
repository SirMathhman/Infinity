package com.meti.server.response;

public class HTMLResponse extends StringResponse {
    public HTMLResponse(String value, ResponseCode responseCode) {
        super(value, responseCode, "text/html");
    }
}
