package com.meti.server.response;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseTypesTest {

    @Test
    void get() {
        String responseType = ResponseTypes.get(Paths.get("test.png"));
        assertEquals("image/png", responseType);
    }
}