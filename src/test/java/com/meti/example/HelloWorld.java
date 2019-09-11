package com.meti.example;

import com.meti.render.ClosedElement;
import com.meti.render.Component;
import com.meti.render.OpenElement;
import com.meti.render.SimpleTag;
import com.meti.server.NanoServerBuilder;
import com.meti.server.Server;
import com.meti.server.context.Context;
import com.meti.server.response.HTMLResponse;
import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.route.SingletonRouter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class HelloWorld {
    private static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        new HelloWorld().run();
    }

    private void run() {
        start();
        awaitTermination();
    }

    private void start() {
        try (Server server = buildServer()) {
            server.run();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to run server.", e);
        }
    }

    private void awaitTermination() {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            boolean shouldContinue;
            do {
                shouldContinue = !scanner.nextLine().equals("exit");
            } while (shouldContinue);
        }
    }

    private Server buildServer() {
        return new NanoServerBuilder()
                .withRouter(new SingletonRouter((Context context) -> process()))
                .build();
    }

    private static Response process() {
        Component title = new ClosedElement(new SimpleTag("title"), "A Title");
        Component head = ClosedElement.compose(new SimpleTag("head"), title);
        Component header = new ClosedElement(new SimpleTag("h1"), "Hello World!");
        Component body = ClosedElement.compose(new SimpleTag("body"), header);
        Component docType = new OpenElement("!DOCTYPE html");
        Component html = ClosedElement.compose(new SimpleTag("html"), head, body);
        return new HTMLResponse(ResponseCodes.OK, Component.compose(docType, html));
    }
}
