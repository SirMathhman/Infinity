package com.meti.app;

import com.meti.lib.State;
import com.meti.lib.fx.Controller;
import com.meti.lib.net.Client;
import com.meti.lib.net.Server;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 3/2/2019
 */
public class ServerDisplay extends Controller {
    private final ExecutorService service = Executors.newCachedThreadPool();
    @FXML
    private ListView<String> clientListView;
    private Server server;

    public ServerDisplay(State state) {
        super(state);
    }

    public void load(ServerSocket serverSocket) {
        State subState = state.createSubState();

        this.server = new InfinityServer(serverSocket, subState);
        this.server.listen(service::submit, Throwable::printStackTrace);

        state.add(server);
        state.add((Closeable) () -> {
            service.shutdown();

            if (!service.isTerminated()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<Runnable> runnables = service.shutdownNow();
                StringBuilder builder = new StringBuilder();
                builder.append("Shutdown service with ").append(runnables.size()).append(" runnables:\n");
                builder.append(runnables.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n")));

                System.err.println(builder);
            }
        });

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

    private Optional<Server> getServer() {
        return Optional.ofNullable(server);
    }

    private class ClientListListener implements ListChangeListener<Client> {
        @Override
        public void onChanged(Change<? extends Client> c) {
            if (c.next()) {
                if (c.wasAdded()) {
                    clientListView.getItems().addAll(mapClients(c.getAddedSubList()));
                } else if (c.wasRemoved()) {
                    clientListView.getItems().removeAll(mapClients(c.getRemoved()));
                } else {
                    throw new UnsupportedOperationException("Invalid change " + c + " for listener");
                }
            } else {
                throw new IllegalStateException("Next change could not be found");
            }
        }
    }

}