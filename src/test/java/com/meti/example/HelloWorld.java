package com.meti.example;


import com.meti.NanoServer;
import com.meti.Route;
import com.meti.Router;
import com.meti.Server;
import com.meti.response.PlainTextResponse;
import com.meti.response.Response;

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
