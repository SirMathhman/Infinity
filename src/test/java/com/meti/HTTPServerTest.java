package com.meti;

import com.meti.http.HTTPServerBuilder;
import com.meti.http.QueueServerBuilder;
import com.meti.response.InlineResponse;
import com.meti.response.Response;
import com.meti.route.Route;
import com.meti.route.SingletonRouter;
import com.meti.server.Server;
import com.meti.server.ServerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTTPServerTest {
    private static final int BACKLOG = 0;
    private static final String CONTENT = "test";
    private static final int PORT = 80;
    private Server server = null;

    @Test
    void construct() throws IOException {
        byte[] data = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals(CONTENT, new String(data, StandardCharsets.UTF_8));
    }

    @BeforeEach
    void setUp() throws IOException {
        ServerBuilder<QueueServerBuilder, Response> builder = new HTTPServerBuilder();
        server = builder.withRouter(new SingletonRouter<>(new TestRoute()))
                .withPort(PORT)
                .withBacklog(BACKLOG)
                .build();
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    private static class TestRoute implements Route<Response> {
        private static final int OK = 200;

        @Override
        public Response process() {
            return new InlineResponse(OK, "test".getBytes(StandardCharsets.UTF_8));
        }
    }
}
