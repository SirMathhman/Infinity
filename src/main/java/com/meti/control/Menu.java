package com.meti.control;

import com.meti.net.client.Client;
import com.meti.net.client.ClientComponent;
import com.meti.net.client.ClientHandler;
import com.meti.net.client.InfinityClientTokenHandler;
import com.meti.concurrent.ExecutorServiceManager;
import com.meti.fx.Injector;
import com.meti.fx.StageManager;
import com.meti.module.InfinityModuleManager;
import com.meti.module.ModuleManager;
import com.meti.net.server.InfinityServerHandler;
import com.meti.net.server.Server;
import com.meti.net.source.SocketSource;
import com.meti.net.source.SocketSourceSupplier;
import com.meti.net.source.URLSource;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 5/7/2019
 */
public class Menu {
    private final Logger logger;
    private final ExecutorServiceManager executorServiceManager;
    private final StageManager stageManager;
    private final ModuleManager moduleManager;

    private Consumer<Server> onServerConstructed;
    private Consumer<Client> onClientConstructed;

    public Menu(Logger logger, ExecutorServiceManager executorServiceManager, StageManager stageManager, InfinityModuleManager moduleManager) {
        this.logger = logger;
        this.executorServiceManager = executorServiceManager;
        this.stageManager = stageManager;
        this.moduleManager = moduleManager;
    }

    @FXML
    public void connect() {

    }

    @FXML
    public void host() {

    }

    @FXML
    public void local() {
        try {
            SocketSourceSupplier supplier = new SocketSourceSupplier();
            constructServer(supplier);

            Stage serverStage = stageManager.getPrimaryStage();
            serverStage.setScene(Injector.loadAsScene(URLSource.of("/com/meti/ServerDisplay.fxml"), supplier));
            serverStage.show();

            Client client = constructClient(supplier.getLocalPort());
            InfinityClientTokenHandler handler = buildClientHandler(client);

            Stage clientStage = stageManager.getStage(1);
            clientStage.setScene(Injector.loadAsScene(URLSource.of("/com/meti/ClientDisplay.fxml"), logger, stageManager, moduleManager, client, handler));
            clientStage.show();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private void constructServer(SocketSourceSupplier supplier) {
        logger.log(Level.INFO, "Constructing server.");
        InfinityServerHandler handler = new InfinityServerHandler();
        Server server = new Server(supplier, executorServiceManager, handler).listen();
        if (onServerConstructed != null) {
            onServerConstructed.accept(server);
        } else {
            logger.log(Level.WARNING, "The server was constructed, but there were no consumers to accept it.");
        }
    }

    private Client constructClient(int localPort) throws IOException {
        logger.log(Level.INFO, "Constructing client.");
        Client client = new Client(new SocketSource(InetAddress.getByName("localhost"), localPort));
        if (onClientConstructed != null) {
            onClientConstructed.accept(client);
        } else {
            logger.log(Level.WARNING, "The client was constructed, but there were no consumers to accept it.");
        }
        return client;
    }

    private InfinityClientTokenHandler buildClientHandler(Client client) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        InfinityClientTokenHandler subHandler = new InfinityClientTokenHandler(moduleManager.constructInstances(ClientComponent.class));
        new ClientHandler(client, subHandler).listen(executorServiceManager);
        return subHandler;
    }

    public void setOnClientConstructed(Consumer<Client> onClientConstructed) {
        this.onClientConstructed = onClientConstructed;
    }

    public void setOnServerConstructed(Consumer<Server> onServerConstructed) {
        this.onServerConstructed = onServerConstructed;
    }
}