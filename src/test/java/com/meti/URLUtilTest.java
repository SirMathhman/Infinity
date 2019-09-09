package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class URLUtilTest {
    private static final String CONTENT = "bar";
    private Path testFile = null;

    @Test
    void readDataFromURL() throws IOException {
        URI uri = testFile.toUri();
        URL url = uri.toURL();
        assertEquals(CONTENT, new String(URLUtil.readDataFromURL(url), StandardCharsets.UTF_8));
    }

    @BeforeEach
    void setUp() throws IOException {
        testFile = Paths.get("foo");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(testFile))) {
            writer.print(CONTENT);
            writer.flush();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(testFile);
    }
}