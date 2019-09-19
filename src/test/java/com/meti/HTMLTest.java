package com.meti;

import com.meti.render.*;
import com.meti.response.HTMLResponse;
import com.meti.response.Response;
import com.meti.response.ResponseCodes;
import com.meti.server.*;
import com.meti.util.URLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTMLTest {
    private Server server = null;

    @Test
    void construct() throws IOException {
        byte[] bytes = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals("<!DOCTYPE html><html></html>", new String(bytes, StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @BeforeEach
    void setUp() throws IOException {
        server = new NanoServer(80, new SingletonRouter(new TestRoute()));
        server.start();
    }

    private static class TestRoute implements Route {
        @Override
        public Response process(Context context) {
            List<Component> list = new ArrayList<>();
            list.add(new Tag("!DOCTYPE html"));
            list.add(new ClosedElementBuilder().withTagName("html").withContent(new SimpleElementContent()).build());
            return new HTMLResponse(ResponseCodes.OK, new Group(list));
        }
    }
}
