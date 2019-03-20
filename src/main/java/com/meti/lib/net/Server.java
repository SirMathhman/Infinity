package com.meti.lib.net;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class Server implements Callable<Void>, Closeable {
    private final List<Socket> socketList = new ArrayList<>();
    private final ServerSocket serverSocket;

    protected Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public Void call() throws Exception {
        while (!serverSocket.isClosed()) {
            Socket accept = serverSocket.accept();
            socketList.add(accept);
            handleAccept(accept);
        }
        return null;
    }

    protected abstract void handleAccept(Socket accept) throws Exception;

    @Override
    public void close() throws IOException {
        serverSocket.close();

        for (Socket socket : socketList) {
            socket.close();
        }
    }
}