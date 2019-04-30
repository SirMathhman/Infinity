package com.meti.app.control;

import com.meti.app.io.InfinityServer;
import com.meti.lib.io.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MenuModel {
    private final Menu menu;

    public MenuModel(Menu menu) {
        this.menu = menu;
    }

    void setupIO() throws IOException {
        int port = Integer.parseInt(menu.portField.getText());
        setupServer(port);
        setupClient(port);
        //TODO: do something with futures
    }

    void setupServer(int port) throws IOException {
        constructServer(port);
        menu.onto(menu.getClass().getResource("/com/meti/app/control/ServerDisplay.fxml"), 0);
    }

    void constructServer(int port) throws IOException {
        InfinityServer server = new InfinityServer(new ServerSocketSupplier(new ServerSocket(port)));
        menu.state.add(server);
        menu.serviceManager.service.submit(server.getListener());
    }

    void setupClient(int port) throws IOException {
        constructClient(port);
        menu.onto(menu.getClass().getResource("/com/meti/app/control/ClientDisplay.fxml"), 1);
    }

    void constructClient(int port) throws IOException {
        ObjectSource<SocketSource> client = new ObjectSource<SocketSource>(new SocketSource(new Socket(InetAddress.getByName("localhost"), port)));
        ObjectChannel channel = client.getChannel(true);
        Querier querier = new Querier(channel);
        menu.serviceManager.service.submit(querier.getListener());
        menu.state.addAll(Arrays.asList(client, channel, querier));
    }
}