package com.meti;

import com.meti.response.PlainTextResponse;
import com.meti.response.ResponseCodes;
import com.meti.response.ResponseTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainTextResponseTest {

    @Test
    void getResponseCode() {
        assertEquals(ResponseCodes.OK, new PlainTextResponse(null).getResponseCode());
    }

    @Test
    void getContentType() {
        assertEquals(ResponseTypes.PLAINTEXT, new PlainTextResponse(null).getContentType());
    }

    @Test
    void getBytes() {
        assertEquals("test", new String(new PlainTextResponse("test").getBytes()));
    }
}