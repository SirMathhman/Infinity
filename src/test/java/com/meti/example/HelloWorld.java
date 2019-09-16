package com.meti.example;


import com.meti.response.PlainTextResponse;
import com.meti.response.Response;
import com.meti.server.NanoServer;
import com.meti.server.Route;
import com.meti.server.Router;
import com.meti.server.Server;

import java.io.IOException;
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
        Server server = new NanoServer(80, new Router(new HelloWorldRoute()));
        server.start();
        waitForExit();
        server.stop();
    }

    private void waitForExit() {
        Scanner scanner = new Scanner(System.in);
        String line;
        do {
            line = scanner.nextLine();
        } while (!line.equals("exit"));
    }

    private static class HelloWorldRoute implements Route {
        @Override
        public Response process() {
            return new PlainTextResponse("Hello World!");
        }
    }
}
