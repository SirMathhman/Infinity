package com.meti;

import com.meti.response.Response;
import com.meti.response.ResponseCodes;
import com.meti.util.URLUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTMLTest {
    private Server server;

    @BeforeEach
    void setUp() throws IOException {
        server = new NanoServer(80, new Router(new TestRoute()));
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @Test
    void construct() throws IOException {
        byte[] bytes = URLUtils.readAllBytes(new URL("http://localhost:80"));
        assertEquals("<!DOCTYPE html><html></html>", new String(bytes));
    }

    public static class TestRoute implements Route {
        @Override
        public Response process() {
            List<Component> list = new ArrayList<>();
            list.add(new Tag("!DOCTYPE html"));
            list.add(new Element("html"));
            return new HTMLResponse(ResponseCodes.OK, new Group(list));
        }
    }
}
