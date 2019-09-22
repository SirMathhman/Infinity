package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleRouteTest {
    private Server server;

    @Test
    void test0() throws IOException {
        URL url = new URL("http://localhost:80/test0");
        byte[] bytes = URLUtils.readAllBytes(url);
        assertEquals("test0", new String(bytes));
    }

    @Test
    void test1() throws IOException {
        URL url = new URL("http://localhost:80/test1");
        byte[] bytes = URLUtils.readAllBytes(url);
        assertEquals("test1", new String(bytes));
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @BeforeEach
    void setUp() throws IOException {
        Set<Route> routes = new HashSet<>();
        routes.add(new TestRoute0());
        routes.add(new TestRoute1());
        server = new NanoServer(80, new CollectionRouter(routes));
        server.start();
    }

    static class TestRoute0 implements Route {
        @Override
        public ByteResponse process() {
            return new ByteResponse(DefaultCode.OK, DefaultType.PLAIN, "test0".getBytes());
        }

        @Override
        public boolean canProcess(Request request) {
            return request.getPath().equals("/test0");
        }
    }

    static class TestRoute1 implements Route {
        @Override
        public Response process() {
            return new ByteResponse(DefaultCode.OK, DefaultType.PLAIN, "test1".getBytes());
        }

        @Override
        public boolean canProcess(Request request) {
            return request.getPath().equals("/test1");
        }
    }
}
