package com.meti.app.control;

import com.meti.app.core.runtime.InfinityState;
import com.meti.lib.State;
import com.meti.lib.concurrent.CompletableConsumer;
import com.meti.lib.fx.FXMLBundle;
import com.meti.lib.util.ExceptionUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.logging.Level;

import static com.meti.lib.fx.StateControllerLoader.loadBundle;

public class Alert extends InfinityController {
    @FXML
    private Text messageText;

    @FXML
    private TextArea stackTraceArea;

    public Alert(State state) {
        super(state);
    }

    public static Optional<Stage> create(Exception exception, InfinityState state) {
        try {
            CompletableConsumer<Stage> consumer = new CompletableConsumer<>();
            FXMLBundle<Alert> bundle = loadBundle(getAlertResource(), state);
            bundle.initRoot(new StageBuilder(consumer))
                    .initController(alert -> alert.show(exception));
            return Optional.of(consumer.get());
        } catch (Exception e) {
            state.getConsole().log(Level.WARNING, e);
            return Optional.empty();
        }
    }

    private void show(Exception exception) {
        messageText.setText(exception.getMessage());
        stackTraceArea.setText(ExceptionUtil.stackTraceString(exception));
    }

    private static URL getAlertResource() {
        return Alert.class.getResource("/com/meti/app/control/Alert.fxml");
    }
}
