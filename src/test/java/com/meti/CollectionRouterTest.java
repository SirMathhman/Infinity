package com.meti;

import com.meti.response.PlainTextResponse;
import com.meti.response.Response;
import com.meti.server.CollectionRouter;
import com.meti.server.Context;
import com.meti.server.Route;
import com.meti.server.Router;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionRouterTest {
    @Test
    void route() {
        Collection<Route> routes = new HashSet<>();
        routes.add(new TestRoute0());
        routes.add(new TestRoute1());
        Router router = new CollectionRouter(routes);
        Response test0Response = router.process(() -> "/test0");
        assertEquals("test0", new String(test0Response.getBytes()));

        Response test1Response = router.process(() -> "/test1");
        assertEquals("test1", new String(test1Response.getBytes()));
    }

    private static class TestRoute0 implements Route {
        @Override
        public boolean canProcess(Context context) {
            return context.getPath().equals("/test0");
        }

        @Override
        public Response process(Context context) {
            return new PlainTextResponse("test0");
        }
    }

    private static class TestRoute1 implements Route {
        @Override
        public boolean canProcess(Context context) {
            return context.getPath().equals("/test1");
        }

        @Override
        public Response process(Context context) {
            return new PlainTextResponse("test1");
        }
    }

}
