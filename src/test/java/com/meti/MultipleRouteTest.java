package com.meti;

import com.meti.server.NanoServerBuilder;
import com.meti.server.Server;
import com.meti.server.ServerBuilder;
import com.meti.server.context.Request;
import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.response.StringResponse;
import com.meti.server.route.CollectionRouter;
import com.meti.server.route.Route;
import com.meti.server.route.Router;
import com.meti.util.URLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleRouteTest {
    private Server server = null;

    @Test
    void route0() throws IOException {
        byte[] testBytes = URLUtils.readAllBytes(new URL("http://localhost:80/route0"));
        assertEquals("route0", new String(testBytes, UTF_8));
    }

    @Test
    void route1() throws IOException {
        byte[] testBytes = URLUtils.readAllBytes(new URL("http://localhost:80/route1"));
        assertEquals("route1", new String(testBytes, UTF_8));
    }

    @BeforeEach
    void setUp() throws IOException {
        Collection<? extends Route> routes = Set.of(
                new Route0(),
                new Route1()
        );
        Router router = new CollectionRouter(routes);
        ServerBuilder builder = new NanoServerBuilder();
        server = builder.withRouter(router).build();
        server.run();
    }

    @AfterEach
    void tearDown() {
        server.terminate();
    }

    private static class Route0 implements Route {
        @Override
        public boolean canProcess(Request request) {
            return request.getPath().equals("/route0");
        }

        @Override
        public Response process(Request request) {
            return new StringResponse(ResponseCodes.OK, "route0");
        }
    }

    private static class Route1 implements Route {
        @Override
        public boolean canProcess(Request request) {
            return request.getPath().equals("/route1");
        }

        @Override
        public Response process(Request request) {
            return new StringResponse(ResponseCodes.OK, "route1");
        }
    }
}