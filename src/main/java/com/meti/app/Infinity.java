package com.meti.app;

import com.meti.app.control.Menu;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/22/2019
 */
public class Infinity implements InfinityImpl {
    private final InfinityInitializer infinityInitializer = new InfinityInitializer();
    private final InfinityState mainState = new InfinityState();

    @Override
    public void start(Stage primaryStage) {
        infinityInitializer.init(mainState, primaryStage);
        startImpl(primaryStage);
    }

    private void logTaskString() {
        mainState.getExecutorServiceManager().getTaskString().ifPresentOrElse(s -> mainState.getConsole().log(Level.SEVERE, s),
                () -> mainState.getConsole().log(Level.INFO, "The ExecutorService has been shutdown with no tasks awaiting execution.")
        );
    }

    private void startImpl(Stage primaryStage) {
        try {
            setAndShowScene(primaryStage, new Scene(Menu.loadMenuParent(mainState)));
        } catch (IOException e) {
            mainState.getConsole().log(Level.SEVERE, e);
        }
    }

    @Override
    public void stop() {
  /*      try {
            stopImpl();
        } catch (Exception e) {
            console.log(Level.SEVERE, e);
        }*/
    }

/*    private void stopImpl() throws Exception {
        terminateExecutor();
    }

    private void terminateExecutor() throws Exception {
        logTaskString();
        executorServiceManager.checkTerminated();
    }*/

    private void setAndShowScene(Stage primaryStage, Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
