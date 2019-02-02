package com.meti.app.control;

import com.meti.app.control.connect.ConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/27/2019
 */
public class Menu extends InfinityController {
    @FXML
    private Text versionText;

    @Override
    public void confirmInfinity() {
        String version = properties.getProperty("version");
        versionText.setText("Version: " + version);
    }

    @FXML
    public void openConnectionManager() {
        try {
            onto(getConnectionManagerURL());
        } catch (IOException e) {
            console.log(Level.WARNING, e);
        }
    }

    private URL getConnectionManagerURL() {
        return getClass().getResource("/com/meti/app/control/ConnectionManager.fxml");
    }


    private URL getServerManagerURL() {
        return getClass().getResource("/com/meti/app/control/ServerManager.fxml");
    }


    @FXML
    public void hostAServer() {
        try {
            onto(getServerManagerURL());
        } catch (IOException e) {
            console.log(Level.WARNING, e);
        }
    }

    @FXML
    public void useLocally() {

    }

    @FXML
    public void openSettings() {
        try {
            Settings settings = onto(getSettingsURL());
            settings.backURL.set(getClass().getResource("/com/meti/app/control/Menu.fxml"));
        } catch (IOException e) {
            console.log(Level.WARNING, e);
        }
    }

    private URL getSettingsURL() {
        return getClass().getResource("/com/meti/app/control/Settings.fxml");
    }
}
