package com.meti;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/11/2019
 */
class Server implements Callable<Void> {
    private final ServerSocket serverSocket;
    private final ExecutorService service;

    public final List<Client> clients = new ArrayList<>();
    public Consumer<Client> onAccept;

    public Server(ServerSocket serverSocket, ExecutorService service) {
        this.serverSocket = serverSocket;
        this.service = service;


        //TODO: add handlers
    }

    @Override
    public Void call() throws Exception {
        while (!serverSocket.isClosed()) {
            Client client = new Client(serverSocket.accept());
            clients.add(client);

            if (onAccept != null) {
                onAccept.accept(client);
            }
            service.submit(new TokenHandler(client));
        }
        return null;
    }
}
