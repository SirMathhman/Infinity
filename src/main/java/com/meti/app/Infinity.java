package com.meti.app;

import com.meti.lib.State;
import com.meti.lib.log.Console;
import com.meti.lib.log.LoggerConsole;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import static com.meti.lib.fx.StateControllerLoader.load;
import static com.meti.lib.util.URLUtil.getResource;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/22/2019
 */
public class Infinity implements InfinityImpl {
    private static final Duration AWAIT_TERMINATION = Duration.ofSeconds(1);
    private final ExecutorServiceManager executorServiceManager;
    private final Console console;
    private final State mainState;

    Infinity() {
        this.executorServiceManager = new ExecutorServiceManager(Executors.newCachedThreadPool(), AWAIT_TERMINATION);
        this.console = new LoggerConsole();
        this.mainState = new State();
    }

    @Override
    public void start(Stage primaryStage) {
        init(primaryStage);
        startImpl(primaryStage);
    }

    private void init(Stage primaryStage) {
        mainState.add(primaryStage);
    }

    private void startImpl(Stage primaryStage) {
        try {
            showMenu(primaryStage);
        } catch (IOException e) {
            console.log(Level.SEVERE, e);
        }
    }

    private void showMenu(Stage primaryStage) throws IOException {
        primaryStage.setScene(createMenuScene());
        primaryStage.show();
    }

    private Scene createMenuScene() throws IOException {
        return new Scene(loadMenuParent());
    }

    private Parent loadMenuParent() throws IOException {
        return load(getResource("/com/meti/app/control/Menu.fxml"), mainState);
    }

    @Override
    public void stop() {
        try {
            stopImpl();
        } catch (Exception e) {
            console.log(Level.SEVERE, e);
        }
    }

    private void stopImpl() throws Exception {
        terminateExecutor();
    }

    private void terminateExecutor() throws Exception {
        logTaskString();
        executorServiceManager.checkTerminated();
    }

    private void logTaskString() {
        executorServiceManager.getTaskString().ifPresentOrElse(
                s -> console.log(Level.SEVERE, s),
                () -> console.log(Level.INFO, "The ExecutorService has been shutdown with no tasks awaiting execution.")
        );
    }
}
