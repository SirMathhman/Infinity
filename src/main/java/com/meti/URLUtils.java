package com.meti;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

final class URLUtils {
    private URLUtils() {
    }

    static byte[] readAllBytes(URL url) throws IOException {
        byte[] testBytes;
        try (InputStream inputStream = url.openStream()) {
            testBytes = inputStream.readAllBytes();
        }
        return testBytes;
    }
}
