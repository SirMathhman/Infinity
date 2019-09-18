package com.meti.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseCodesTest {

    @Test
    void getValue() {
        assertEquals(400, ResponseCodes.BAD_REQUEST.getValue());
    }
}