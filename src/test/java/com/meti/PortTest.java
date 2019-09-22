package com.meti;

import com.meti.net.*;
import com.meti.net.response.ByteResponse;
import com.meti.net.response.DefaultCode;
import com.meti.net.response.DefaultType;
import com.meti.net.router.SingletonRouter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortTest {
    private Server server;

    @Test
    void construct() throws IOException {
        URL url = new URL("http://localhost:25565");
        byte[] bytes = URLUtils.readAllBytes(url);
        assertEquals("test", new String(bytes));
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @BeforeEach
    void setUp() throws IOException {
        server = new NanoServer(25565, new SingletonRouter(new TestRoute()));
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
