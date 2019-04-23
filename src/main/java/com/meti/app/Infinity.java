package com.meti.app;

import com.meti.lib.State;
import javafx.stage.Stage;

import java.time.Duration;
import java.util.concurrent.Executors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/22/2019
 */
public class Infinity implements InfinityImpl {
    private final ExecutorServiceManager executorServiceManager;
    private final State mainState;

    public Infinity() {
        this.executorServiceManager = new ExecutorServiceManager(Executors.newCachedThreadPool(), Duration.ofSeconds(1));
        this.mainState = new State();
    }

    @Override
    public void start(Stage primaryStage) {
        mainState.add(primaryStage);
    }

    @Override
    public void stop() {
        try {
            executorServiceManager.terminateExecutor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
