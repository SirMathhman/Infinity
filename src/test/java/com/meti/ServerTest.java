package com.meti;

import com.meti.util.URLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerTest {
    private Server server;

    @BeforeEach
    void setUp() throws IOException {
        server = new NanoServer(80, new Router(new TestRoute()));
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @Test
    void construct() throws IOException {
        byte[] bytes = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals("test", new String(bytes));
    }

    public static class TestRoute implements Route {
        @Override
        public Response process() {
            return new InlineResponse(ResponseCodes.OK, new ContentType("text/plain"), "test".getBytes());
        }
    }
}
