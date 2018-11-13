package com.meti.lib.net;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 11/10/2018
 */
public class ServerListener implements Callable<Set<Client<SocketConnection>>> {
    public final ObservableSet<Client<SocketConnection>> clients = FXCollections.emptyObservableSet();
    public final BooleanProperty runningProperty = new SimpleBooleanProperty();
    private final ClientConsumer clientConsumer;
    private final ServerSocket serverSocket;

    public Consumer<Client> onClientConnect;

    ServerListener(ClientConsumer clientConsumer, ServerSocket serverSocket) {
        this.clientConsumer = clientConsumer;
        this.serverSocket = serverSocket;
    }

    @Override
    public Set<Client<SocketConnection>> call() throws Exception {
        try {
            while (runningProperty.get()) {
                Socket socket = serverSocket.accept();
                Client<SocketConnection> client = new Client<>(new SocketConnection(socket));
                clients.add(client);
                clientConsumer.accept(client);
            }

            //TODO: not sure what to return in this instance...
            return clients;
        } catch (SocketException e) {
            return clients;
        }
    }
}
