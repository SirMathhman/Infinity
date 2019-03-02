package com.meti.app;

import com.meti.lib.net.Client;
import com.meti.lib.net.Server;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 3/2/2019
 */
public class ServerDisplay {
    @FXML
    private ListView<String> clientListView;

    private Server server;

    public void load(ServerSocket serverSocket) {
        this.server = new Server(serverSocket);

        loadClients();
    }

    private void loadClients() {
        Server server = getServer().orElseThrow(() -> new IllegalStateException("Server has not been set"));
        clientListView.getItems().addAll(mapClients(server.clients));
        server.clients.addListener(new ClientListListener());
    }

    private List<String> mapClients(List<? extends Client> clients) {
        return clients.stream().map(client -> client.socket)
                .map(Socket::getInetAddress)
                .map(InetAddress::toString)
                .collect(Collectors.toList());
    }

    private Optional<Server> getServer(){
        return Optional.ofNullable(server);
    }

    private class ClientListListener implements ListChangeListener<Client> {
        @Override
        public void onChanged(Change<? extends Client> c) {
            if (c.wasAdded()) {
                clientListView.getItems().addAll(mapClients(c.getAddedSubList()));
            } else if (c.wasRemoved()) {
                clientListView.getItems().removeAll(mapClients(c.getRemoved()));
            } else {
                throw new UnsupportedOperationException("Invalid change " + c + " for listener");
            }
        }
    }
}
