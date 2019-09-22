package com.meti;

import com.meti.net.response.DefaultCode;
import com.meti.net.response.Response;
import com.meti.net.route.AssetRoute;
import com.meti.net.route.Router;
import com.meti.net.route.SingletonRouter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AssetRouteTest {
    private Path rootDirectory;
    private Path testDirectory;
    private Path path;

    @BeforeEach
    void setUp() throws IOException {
        this.rootDirectory = Paths.get("files");
        this.testDirectory = rootDirectory.resolve("test");
        this.path = testDirectory.resolve("test.txt");
        if (!exists(testDirectory)) createDirectories(testDirectory);
        if (!exists(path)) createFile(path);
        try (PrintWriter writer = new PrintWriter(newBufferedWriter(path))) {
            writer.print("test");
            writer.flush();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        deleteIfExists(path);
        deleteIfExists(testDirectory);
        deleteIfExists(rootDirectory);
    }

    @Test
    void construct() {
        Router router = new SingletonRouter(new AssetRoute(rootDirectory));
        Response response = router.process(() -> "/assets/test/test.txt");
        assertEquals(DefaultCode.OK, response.getResponseCode());
        assertEquals("text/plain", response.getResponseType().getValue());
        assertEquals("test", new String(response.getBytes()));
    }
}
