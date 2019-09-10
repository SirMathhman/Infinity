package com.meti;

import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.response.StringResponse;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class StringResponseTest {
    @Test
    void construct() {
        Response response = new StringResponse(ResponseCodes.BAD_REQUEST, "test");
        assertEquals("test", new String(response.getData(), StandardCharsets.UTF_8));
        assertEquals(ResponseCodes.BAD_REQUEST, response.getResponseCode());
    }
}