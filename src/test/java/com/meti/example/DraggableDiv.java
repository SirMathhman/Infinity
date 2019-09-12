package com.meti.example;

import com.meti.server.NanoServerBuilder;
import com.meti.server.Server;
import com.meti.server.route.Route;
import com.meti.server.route.SingletonRouter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class DraggableDiv {
    private static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        new DraggableDiv().run();
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
        Route route = new DraggableDivRoute();
        return new NanoServerBuilder()
                .withRouter(new SingletonRouter(route))
                .build();
    }
}
