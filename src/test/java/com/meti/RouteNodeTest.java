package com.meti;

import com.meti.response.PlainTextResponse;
import com.meti.response.Response;
import com.meti.server.CollectionRouter;
import com.meti.server.Context;
import com.meti.server.Route;
import com.meti.server.Router;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouteNodeTest {
    @Test
    void construct() {
        Response response = new PlainTextResponse("test");
        ParentRoute root = new Test0(response);
        Collection<Route> routes = ParentRoute.collect(root);
        Router router = new CollectionRouter(routes);
        assertEquals(response, router.process(() -> "/child"));
    }

    private static class Test1 extends SetParentRoute {
        private Response response;

        public Test1(Response response) {
            this.response = response;
        }

        @Override
        public String getPath() {
            return "/child";
        }

        @Override
        public Response process(Context context) {
            return response;
        }
    }

    private static class Test0 extends SetParentRoute {
        private Response response;

        public Test0(Response response) {
            this.response = response;
        }

        @Override
        public void onCollect() {
            with(new Test1(response));
        }

        @Override
        public String getPath() {
            return "/parent";
        }

        @Override
        public Response process(Context context) {
            return null;
        }
    }
}
