package com.meti.net.route;

import com.meti.net.Request;
import com.meti.net.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PathRouteTest {

    @Test
    void canProcess() {
        Route route = new TestRoute();
        Request request = () -> "/test";
        assertTrue(route.canProcess(request));
    }

    private static class TestRoute implements PathRoute {
        @Override
        public String getPath() {
            return "/test";
        }

        @Override
        public Response process(Request request) {
            fail();
            return null;
        }
    }
}