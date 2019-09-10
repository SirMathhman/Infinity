package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Set;

import static com.meti.ResponseCodes.OK;
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
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    private static class CollectionRouter implements Router {
        private final Collection<? extends Route> routes;

        CollectionRouter(Collection<? extends Route> routes) {
            this.routes = routes;
        }

        @Override
        public Response route(Context context) {
            return routes.stream()
                    .filter(route -> route.canProcess(context))
                    .findAny()
                    .orElseThrow()
                    .process();
        }
    }

    private static class Route0 implements Route {
        @Override
        public boolean canProcess(Context context) {
            return context.getPath().equals("/route0");
        }

        @Override
        public Response process() {
            return new StringResponse(OK, "route0");
        }
    }

    private static class Route1 implements Route {
        @Override
        public boolean canProcess(Context context) {
            return context.getPath().equals("/route1");
        }

        @Override
        public Response process() {
            return new StringResponse(OK, "route1");
        }
    }
}