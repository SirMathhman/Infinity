package com.meti;

import com.meti.response.InlineResponse;
import com.meti.response.Response;
import com.meti.response.ResponseCodes;
import com.meti.response.ResponseTypes;
import com.meti.server.NanoServer;
import com.meti.server.Route;
import com.meti.server.Server;
import com.meti.server.SingletonRouter;
import com.meti.util.URLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerTest {
    private Server server = null;

    @Test
    void construct() throws IOException {
        byte[] bytes = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals("test", new String(bytes, StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @BeforeEach
    void setUp() throws IOException {
        server = new NanoServer(80, new SingletonRouter(new TestRoute()));
        server.start();
    }

    private static class TestRoute implements Route {
        @Override
        public Response process() {
            return new InlineResponse(ResponseCodes.OK, new ResponseTypes("text/plain"),
                    "test".getBytes(StandardCharsets.UTF_8));
        }
    }
}
