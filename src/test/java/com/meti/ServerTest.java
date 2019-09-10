package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerTest {
    private Server server = null;

    @BeforeEach
    void setUp() throws IOException {
        Router router = new SingletonRouter(new TestRoute());
        ServerBuilder builder = new NanoServerBuilder();
        server = builder.withRouter(router).build();
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @Test
    void test() throws IOException {
        byte[] testBytes = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals("test", new String(testBytes, UTF_8));
    }

    private static class TestRoute implements Route {
        @Override
        public Response process() {
            byte[] bytes = "test".getBytes(UTF_8);
            String mime = "text/plain";
            return new InlineResponse(bytes, mime, ResponseCodes.OK);
        }
    }
}