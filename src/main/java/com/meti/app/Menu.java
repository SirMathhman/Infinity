package com.meti.app;

import com.meti.lib.collect.State;
import com.meti.lib.fx.Controller;
import com.meti.lib.fx.ControllerLoaderFunction;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/7/2019
 */
public class Menu extends InfinityController {
    @FXML
    private Text versionText;

    public Menu(State state, Stage stage) {
        super(state, stage);
    }

    Local loadLocal() throws IOException {
        return onto(
                getLocalURL().openStream(),
                factory.apply(new ControllerLoaderFunction<Local>(Controller.this))
                        .andThen(Optional::orElseThrow)
        );
    }

    static URL getLocalURL() {
        return Infinity.class.getResource("/com/meti/app/Local.fxml");
    }

    @FXML
    public void local() {
        factory.accept(this::loadLocal);
    }

    @FXML
    public void openSettings() {

    }

}
