package com.meti.control;

import com.meti.concurrent.ExecutorServiceManager;
import com.meti.fx.Injector;
import com.meti.fx.StageManager;
import com.meti.module.InfinityModuleManager;
import com.meti.net.source.URLSource;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.meti.util.ExceptionUtil.stackTraceString;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 5/7/2019
 */
public class Menu extends InfinityController {
    private final MenuModel menuModel;

    public Menu(Logger logger, ExecutorServiceManager executorServiceManager, StageManager stageManager, InfinityModuleManager moduleManager) {
        super(logger, executorServiceManager, stageManager, moduleManager);
        menuModel = new MenuModel(logger, executorServiceManager, stageManager, moduleManager);
    }

    @FXML
    public void connect() {
        try {
            Stage stage = stageManager.getStage(0);
            stage.setScene(new Scene(new Injector(URLSource.of("/com/meti/ConnectMenu.fxml"),logger, executorServiceManager, stageManager, moduleManager, menuModel.getClientLoader()).load()));
            stage.show();
        } catch (IOException e) {
            logger.log(Level.SEVERE, stackTraceString(e));
        }
    }

    public MenuModel getModel() {
        return menuModel;
    }

    @FXML
    public void local() {
        try {
            menuModel.loadClient(menuModel.loadServer());
        } catch (Exception e) {
            logger.log(Level.SEVERE, stackTraceString(e));
        }
    }
}
