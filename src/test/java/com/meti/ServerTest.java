package com.meti;

import com.meti.response.HTMLType;
import com.meti.response.InlineResponse;
import com.meti.response.Response;
import com.meti.response.ResponseCodes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerTest {
    private static final String CONTENT = "test";
    private final Server server = new NanoServer(new TestRoute(CONTENT));

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

    private static final class TestRoute implements Route {
        private final String content;

        private TestRoute(String content) {
            this.content = content;
        }

        @Override
        public Response process() {
            return new InlineResponse(ResponseCodes.OK, new HTMLType(), content.getBytes(StandardCharsets.UTF_8));
        }
    }
}
