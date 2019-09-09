package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerTest {
    private static final String CONTENT = "test";
    private final Server server = new NanoServer(new TestRoute());

    @Test
    void construct() throws IOException {
        byte[] data = URLUtil.readDataFromURL(new URL("http://localhost:80"));
        assertEquals(CONTENT, new String(data, StandardCharsets.UTF_8));
    }

    @BeforeEach
    void setUp() throws IOException {
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    private static class TestRoute implements Route {
        private final ContentType contentType = new HTMLType();

        @Override
        public Response process() {
            return new InlineResponse(ResponseCode.OK, contentType, CONTENT.getBytes(StandardCharsets.UTF_8));
        }
    }
}
