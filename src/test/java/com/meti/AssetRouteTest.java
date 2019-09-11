package com.meti;

import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.route.AssetRoute;
import com.meti.server.route.Router;
import com.meti.server.route.SingletonRouter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import static java.nio.file.Files.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssetRouteTest {
    private Path files = null;
    private Path testPath = null;

    @Test
    void route() {
        Router router = new SingletonRouter(new AssetRoute(files, "/assets"));
        Response response = router.route(() -> "/assets/test.txt");
        assertEquals(ResponseCodes.OK, response.getResponseCode());
        assertEquals("test", new String(response.getData(), StandardCharsets.UTF_8));
        assertEquals("text/plain", response.getType());
    }

    @Test
    void routeMissing() {
        Router router = new SingletonRouter(new AssetRoute(files, "/assets"));
        assertThrows(NoSuchElementException.class, () -> router.route(() -> "/assets/foo.txt"));
    }

    @BeforeEach
    void setUp() throws IOException {
        files = Paths.get("files");
        if (!exists(files)) createDirectory(files);
        testPath = files.resolve("test.txt");
        if (!exists(testPath)) createFile(testPath);
        try (PrintWriter writer = new PrintWriter(newBufferedWriter(testPath))) {
            writer.print("test");
            writer.flush();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        delete(testPath);
        delete(files);
    }

}