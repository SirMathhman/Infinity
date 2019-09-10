package com.meti;

import com.meti.nano.NanoServerBuilder;
import com.meti.route.SingletonRouter;
import com.meti.server.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleServerTest {
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
        server = new NanoServerBuilder()
                .withPort(PORT)
                .withRouter(new SingletonRouter<>(new SimpleTestRoute()))
                .build();
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

}
