package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RouteTest {

    @Test
    void canProcess() {
        assertTrue(((Route) () -> {
            throw new UnsupportedOperationException();
        }).canProcess(null));
    }
}