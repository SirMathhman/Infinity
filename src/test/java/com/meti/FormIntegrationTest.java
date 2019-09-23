package com.meti;

import com.meti.net.*;
import com.meti.net.response.ByteResponse;
import com.meti.net.response.DefaultCode;
import com.meti.net.response.DefaultType;
import com.meti.net.response.Response;
import com.meti.net.route.*;
import com.meti.render.node.*;
import fi.iki.elonen.NanoHTTPD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormIntegrationTest {
    private static final int EXPECTED = 5;
    private final CompletableFuture<Integer> actual = new CompletableFuture<>();
    private Server server;

    @BeforeEach
    void setUp() throws IOException {
        Collection<Route> routes = new HashSet<>();
        routes.add(new TestRoute());
        Router router = new CollectionRouter(routes);
        server = new NanoServer(80, router);
        server.start();
    }

    @Test
    void verify() throws ExecutionException, InterruptedException {
        Integer integer = actual.get();
        assertEquals(EXPECTED, integer);
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    private class TestRoute implements PathRoute {
        private static final String SCRIPT_CONTENT =
                "const form=document.getElementById(\"test\");" +
                        "form.submit()";

        private final Map<Method, Processor> processorMap = new EnumMap<>(Method.class);

        TestRoute() {
            processorMap.put(Method.GET, this::processGet);
            processorMap.put(Method.POST, this::processPost);
        }

        private Response processPost(Request request) {
            try {
                RequestBody requestBody = request.parseRequestBody();
                actual.complete(parseData(requestBody));
                return new ByteResponse(DefaultCode.OK);
            } catch (IOException | NanoHTTPD.ResponseException e) {
                throw new RuntimeException(e);
            }
        }

        private int parseData(RequestBody requestBody) {
            Map<String, List<String>> data = requestBody.getData();
            List<String> entries = data.get("data");
            String firstEntry = entries.get(0);
            return Integer.parseInt(firstEntry);
        }

        @Override
        public String getPath() {
            return "/test";
        }

        @Override
        public Response process(Request request) {
            return processorMap.get(request.getMethod()).process(request);
        }

        private Response processGet(Request request) {
            Node input = buildInput();
            NodeData data = buildData();
            Node form = buildForm(input, data);
            Node root = new Divider(form, new InlineScript(SCRIPT_CONTENT));
            Node scene = buildScene(root);
            return new SceneResponse(DefaultCode.OK, DefaultType.HTML, scene);
        }

        private Form buildForm(Node input, NodeData data) {
            return new FormBuilder()
                    .withAction(this)
                    .withNodeData(data)
                    .withMethod(Method.POST)
                    .withChildren(singleton(input))
                    .build();
        }

        private NodeData buildData() {
            NodeDataBuilder builder = new SimpleNodeDataBuilder();
            return builder.withID("test")
                    .build();
        }

        private Node buildScene(Node root) {
            return new SimpleSceneBuilder()
                    .withCharSet(Charset.defaultCharset())
                    .withLocale(Locale.getDefault())
                    .withTitle("Get")
                    .withRoot(root)
                    .build();
        }

        private Node buildInput() {
            return new SimpleInputBuilder()
                    .withID("data")
                    .withInitialValue(EXPECTED)
                    .withInputType(InputType.HIDDEN)
                    .build();
        }
    }
}
