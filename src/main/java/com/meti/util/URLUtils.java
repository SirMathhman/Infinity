package com.meti.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class URLUtils {
    private URLUtils() {
    }

    public static byte[] readAllBytes(URL url) throws IOException {
        byte[] testBytes;
        try (InputStream inputStream = url.openStream()) {
            testBytes = inputStream.readAllBytes();
        }
        return testBytes;
    }
}
