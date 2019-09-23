package com.meti;

import com.meti.net.response.DefaultCode;
import com.meti.net.response.Response;
import com.meti.net.route.*;
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
    private Path testPath;

    @BeforeEach
    void setUp() throws IOException {
        this.rootDirectory = Paths.get("files");
        this.testDirectory = rootDirectory.resolve("test");
        this.testPath = testDirectory.resolve("test.txt");
        if (!exists(testDirectory)) createDirectories(testDirectory);
        if (!exists(testPath)) createFile(testPath);
        try (PrintWriter writer = new PrintWriter(newBufferedWriter(testPath))) {
            writer.print("test");
            writer.flush();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        deleteIfExists(testPath);
        deleteIfExists(testDirectory);
        deleteIfExists(rootDirectory);
    }

    @Test
    void construct() {
        Router router = new SingletonRouter(new PathAssetRoute(rootDirectory, "/assets"));
        RequestBuilder builder = new InlineRequestBuilder();
        Response response = router.process(builder.withPath("/assets/test/test.txt").build());
        assertEquals(DefaultCode.OK, response.getResponseCode());
        assertEquals("text/plain", response.getResponseType().getValue());
        assertEquals("test", new String(response.getBytes()));
    }

    @Test
    void buildWebPath() {
        AssetRoute<Path> assetRoute = new PathAssetRoute(rootDirectory, "/assets");
        String webPath = assetRoute.buildWebPath(testPath);
        assertEquals("/assets/test/test.txt", webPath);
    }
}
