package com.meti;

import com.meti.server.response.ResponseCodes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseCodesTest {

    @Test
    void getValue() {
        assertEquals(200, ResponseCodes.OK.getValue());
        assertEquals(400, ResponseCodes.BAD_REQUEST.getValue());
    }
}