package com.meti;

import com.meti.server.response.HTMLResponse;
import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTMLResponseTest {
    @Test
    void construct() {
        String value = "<!DOCTYPE html><html></html>";
        Response response = new HTMLResponse(value, ResponseCodes.OK);
        assertEquals(value, new String(response.getData(), StandardCharsets.UTF_8));
        assertEquals(ResponseCodes.OK, response.getResponseCode());
        assertEquals("text/html", response.getType());
    }
    @Test
    void construct0() {
        String value = "<!DOCTYPE html>";
        Response response = new HTMLResponse(value, ResponseCodes.BAD_REQUEST);
        assertEquals(value, new String(response.getData(), StandardCharsets.UTF_8));
        assertEquals(ResponseCodes.BAD_REQUEST, response.getResponseCode());
        assertEquals("text/html", response.getType());
    }
}