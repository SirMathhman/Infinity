package com.meti.app;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ExecutorServiceManager {
    private final RunnableLister runnableLister = new RunnableLister();
    private final Duration terminationDuration;
    private final ExecutorService service;

    ExecutorServiceManager(ExecutorService service, Duration terminationDuration) {
        this.service = service;
        this.terminationDuration = terminationDuration;
    }

    void checkTerminated() throws Exception {
        if (!service.isTerminated()) {
            terminate();
        }
    }

    private void terminate() throws InterruptedException, TimeoutException {
        if (!terminationSuccessful()) {
            throw new TimeoutException("Service failed to terminate within " + terminationDuration.toString());
        }
    }

    private boolean terminationSuccessful() throws InterruptedException {
        return !service.awaitTermination(terminationDuration.toMillis(), TimeUnit.MILLISECONDS);
    }

    String getTaskString() {
        if (service.isShutdown()) {
            throw new IllegalStateException("Service should still be running!");
        }

        return runnableLister.createTaskString(service.shutdownNow());
    }
}