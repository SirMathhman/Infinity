package com.meti;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class URLUtilsTest {
    private static final String CONTENT = "content";
    private Path testPath = null;

    @BeforeEach
    void setUp() throws IOException {
        testPath = Paths.get("test");
        if(!Files.exists(testPath)) Files.createFile(testPath);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(testPath))) {
            writer.print(CONTENT);
            writer.flush();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(testPath);
    }

    @Test
    void readAllBytes() throws IOException {
        byte[] bytes = URLUtils.readAllBytes(testPath.toUri().toURL());
        assertEquals(CONTENT, new String(bytes, StandardCharsets.UTF_8));
    }
}