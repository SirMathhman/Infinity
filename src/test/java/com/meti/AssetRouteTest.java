package com.meti;

import com.meti.response.Response;
import com.meti.server.AssetRoute;
import com.meti.server.Router;
import com.meti.server.SingletonRouter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.meti.response.ResponseCodes.OK;
import static java.nio.file.Files.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AssetRouteTest {
    private static final String CONTENT = "test";
    private Path testDirectory;
    private Path testPath;

    @BeforeEach
    void setUp() throws IOException {
        testDirectory = Paths.get("files");
        testPath = testDirectory.resolve("test")
                .resolve("test.txt");
        if (!exists(testPath.getParent())) createDirectories(testPath.getParent());
        if (!exists(testPath)) createFile(testPath);
        try (PrintWriter writer = new PrintWriter(newBufferedWriter(testPath))) {
            writer.print(CONTENT);
            writer.flush();
        }
    }

    @Test
    void construct() {
        Router router = new SingletonRouter(new AssetRoute("/assets", testDirectory));
        Response response = router.process(() -> "/assets/test/test.txt");
        assertEquals(OK, response.getResponseCode());
        assertEquals("text/plain", response.getContentType().getValue());
        assertEquals(CONTENT, new String(response.getBytes()));
    }

    @AfterEach
    void tearDown() throws IOException {
        delete(testPath);
        delete(testPath.getParent());
        delete(testPath.getParent().getParent());
    }

}
