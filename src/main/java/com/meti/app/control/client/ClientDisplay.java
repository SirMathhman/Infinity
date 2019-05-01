package com.meti.app.control.client;

import com.meti.app.control.view.ViewModel;
import com.meti.lib.fx.ControllerLoader;
import com.meti.lib.util.Streams;
import com.meti.lib.util.collect.State;
import com.meti.lib.util.tryable.TryableConsumer;
import com.meti.lib.util.tryable.TryableFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/30/2019
 */
public class ClientDisplay extends InfinityClientController implements Initializable {
    private final Map<String, Parent> views = new HashMap<>();

    @FXML
    private Text addressText;

    @FXML
    private Text portText;

    @FXML
    private ListView<String> viewListView;

    public ClientDisplay(State state) {
        super(state);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Socket socket = client.source.socket;
        setText(socket.getInetAddress(), socket.getLocalPort());
        loadViews(console.getFactory(), state.getModuleManager().getImplementations(ViewModel.class));
    }

    private void loadViews(TryableFactory factory, Stream<Class<?>> implementations) {
        Streams.instanceStream(factory, implementations)
                .forEach(factory.constructConsumerFrom(new ViewInitializer()));
    }

    private void setText(InetAddress inetAddress, int localPort) {
        addressText.setText(inetAddress.toString());
        portText.setText(String.valueOf(localPort));
    }

    @FXML
    public void open() {
        selectedViewStream()
                .map(views::get)
                .map(parent -> stageManager.addRootToStage(parent))
                .forEach(Stage::show);
    }

    private Stream<String> selectedViewStream() {
        return viewListView.getSelectionModel()
                .getSelectedItems()
                .stream();
    }

    private class ViewInitializer implements TryableConsumer<Object> {
        @Override
        public void accept(Object o) throws Exception {
            ViewModel viewModel = (ViewModel) o;
            Parent root = ControllerLoader.loadFXMLBundleFrom(viewModel.getURL(), state).root;
            String name = viewModel.getName();
            viewListView.getItems().add(name);
            views.put(name, root);
        }
    }
}
