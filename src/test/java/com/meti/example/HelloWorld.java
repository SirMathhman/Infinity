package com.meti.example;


import com.meti.response.PlainTextResponse;
import com.meti.response.Response;
import com.meti.server.NanoServer;
import com.meti.server.Route;
import com.meti.server.Server;
import com.meti.server.SingletonRouter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        new HelloWorld().run();
    }

    private void run() {
        try {
            runExceptionally();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runExceptionally() throws IOException {
        Server server = new NanoServer(80, new SingletonRouter(new HelloWorldRoute()));
        server.start();
        waitForExit();
        server.stop();
    }

    private void waitForExit() {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            boolean shouldContinue;
            do {
                shouldContinue = !scanner.nextLine().equals("exit");
            } while (shouldContinue);
        }
    }

    private static class HelloWorldRoute implements Route {
        @Override
        public Response process() {
            return new PlainTextResponse("Hello World!");
        }
    }
}
