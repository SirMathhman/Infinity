package com.meti;

import com.meti.net.*;
import com.meti.net.response.ByteResponse;
import com.meti.net.response.DefaultCode;
import com.meti.net.response.DefaultType;
import com.meti.net.router.MutableRouter;
import com.meti.net.router.SetRouter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetRouterTest {
    private Server server;

    @Test
    void construct() throws IOException {
        URL url = new URL("http://localhost:80");
        byte[] bytes = URLUtils.readAllBytes(url);
        assertEquals("test", new String(bytes));
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @BeforeEach
    void setUp() throws IOException {
        MutableRouter router = new SetRouter();
        router.with(new TestRoute());
        server = new NanoServer(80, router);
        server.start();
    }

    static class TestRoute implements Route {
        @Override
        public ByteResponse process() {
            return new ByteResponse(DefaultCode.OK, DefaultType.PLAIN, "test".getBytes());
        }

        @Override
        public boolean canProcess(Request request) {
            return true;
        }
    }
}
