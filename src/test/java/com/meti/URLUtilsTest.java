package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class URLUtilsTest {
    private static final String CONTENT = "content";
    private Path content = null;

    @Test
    void readAllBytes() throws IOException {
        URI uri = content.toUri();
        byte[] bytes = URLUtils.readAllBytes(uri.toURL());
        assertEquals(CONTENT, new String(bytes, StandardCharsets.UTF_8));
    }

    @BeforeEach
    void setUp() throws IOException {
        content = Paths.get("test");
        Files.createFile(content);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(content))) {
            writer.print(CONTENT);
            writer.flush();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(content);
    }
}