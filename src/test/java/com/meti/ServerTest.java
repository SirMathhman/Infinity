package com.meti;

import com.meti.server.NanoServerBuilder;
import com.meti.server.Server;
import com.meti.server.ServerBuilder;
import com.meti.server.context.Request;
import com.meti.server.response.InlineResponse;
import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.route.Route;
import com.meti.server.route.Router;
import com.meti.server.route.SingletonRouter;
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
        server.run();
    }

    @AfterEach
    void tearDown() {
        server.terminate();
    }

    @Test
    void test() throws IOException {
        byte[] testBytes = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals("test", new String(testBytes, UTF_8));
    }

    private static class TestRoute implements Route {
        @Override
        public Response process(Request request) {
            byte[] bytes = "test".getBytes(UTF_8);
            String mime = "text/plain";
            return new InlineResponse(ResponseCodes.OK, mime, bytes);
        }
    }
}