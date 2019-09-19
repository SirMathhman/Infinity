package com.meti;

import com.meti.render.*;
import com.meti.response.HTMLResponse;
import com.meti.response.Response;
import com.meti.response.ResponseCodes;
import com.meti.server.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

class ImageExample {

    private Server server;

    public static void main(String[] args) {
        new ImageExample().run();
    }

    private void run() {
        try {
            runExceptionally();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runExceptionally() throws IOException {
        start();
        waitForExit();
        stop();
    }

    private void stop() {
        server.stop();
    }

    private void waitForExit() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean shouldContinue;
            do {
                shouldContinue = !scanner.nextLine().equals("exit");
            } while (shouldContinue);
        }
    }

    private void start() throws IOException {
        Collection<Route> routes = new HashSet<>();
        routes.add(new AssetRoute(Paths.get("src", "test", "resources"), "/images"));
        routes.add(new HomeRoute());
        Router router = new CollectionRouter(routes);
        server = new NanoServer(80, router);
        server.start();
    }

    private static final class HomeRoute implements Route {
        @Override
        public boolean canProcess(Context context) {
            return context.getPath().equals("/");
        }

        @Override
        public Response process(Context context) {
            List<Component> list = new ArrayList<>();
            list.add(new Tag("!DOCTYPE html"));
            list.add(new ClosedElementBuilder()
                    .withTagName("html")
                    .withContent(buildHTMLContent())
                    .build());
            return new HTMLResponse(ResponseCodes.OK, new Group(list));
        }

        private ElementContent buildHTMLContent() {
            Component head = buildHead();
            Component body = buildBody();
            return new SimpleElementContent()
                    .append(head)
                    .append(body);
        }

        private Component buildBody() {
            ElementContent bodyContent = new SimpleElementContent();
            bodyContent.append(buildImage());
            return new ClosedElementBuilder()
                    .withTagName("body")
                    .withContent(bodyContent)
                    .build();
        }

        private Component buildImage() {
            Map<String, String> attributes = new HashMap<>();
            attributes.put("src", "/images/crappyImage.png");
            Component imageAttributes = new MapAttributes(attributes);
            return new OpenElement("img", imageAttributes);
        }

        private Component buildHead() {
            ElementContent headContent = new SimpleElementContent();
            return new ClosedElementBuilder()
                    .withTagName("head")
                    .withContent(headContent)
                    .build();
        }
    }
}
