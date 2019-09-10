package com.meti;

import com.meti.response.Response;
import com.meti.response.StringResponse;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StringResponseTest {
    private static final String CONTENT = "test";

    @Test
    void getContentBytes() {
        Response response = new StringResponse();
        assertArrayEquals(CONTENT.getBytes(StandardCharsets.UTF_8), response.getContentBytes());
    }
}