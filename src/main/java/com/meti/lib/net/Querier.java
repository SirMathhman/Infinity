package com.meti.lib.net;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/11/2019
 */
public class Querier implements Callable<Void> {
    private final BlockingQueue<CompletableFuture<Object>> futures = new ArrayBlockingQueue<>(16);
    private final Client client;

    public Querier(Client client) {
        this.client = client;
    }

    @Override
    public Void call() throws Exception {
        while (!client.socket.isClosed()) {
            Object token = client.readObject();
            if (token instanceof Throwable) {
                futures.take().completeExceptionally((Throwable) token);
            } else {
                futures.take().complete(token);
            }
        }
        return null;
    }

    public CompletableFuture<Object> query(Object input) throws IOException {
        client.writeObject(input);
        client.flush();

        CompletableFuture<Object> future = new CompletableFuture<>();
        futures.offer(future);
        return future;
    }

}