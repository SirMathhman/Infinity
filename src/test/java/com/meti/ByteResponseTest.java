package com.meti;

import com.meti.net.response.ByteResponse;
import com.meti.net.response.DefaultCode;
import com.meti.net.response.DefaultType;
import com.meti.net.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ByteResponseTest {
    private static final String CONTENT = "test";
    private final Response response = new ByteResponse(DefaultCode.BAD_REQUEST, DefaultType.HTML, CONTENT.getBytes());

    @Test
    void getResponseCode() {
        assertEquals(DefaultCode.BAD_REQUEST, response.getResponseCode());
    }

    @Test
    void getResponseType() {
        assertEquals(DefaultType.HTML, response.getResponseType());
    }

    @Test
    void getBytes() {
        assertEquals(CONTENT, new String(response.getBytes()));
    }
}