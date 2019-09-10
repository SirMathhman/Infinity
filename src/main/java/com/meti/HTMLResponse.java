package com.meti;

class HTMLResponse extends StringResponse {
    HTMLResponse(String value, ResponseCode responseCode) {
        super(value, responseCode, "text/html");
    }
}
