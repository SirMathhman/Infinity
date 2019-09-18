package com.meti.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class URLUtils {
    private URLUtils() {
    }

    public static byte[] readAllBytes(URL url) throws IOException {
        byte[] bytes;
        try (InputStream inputStream = url.openStream()) {
            int bytesExpected = inputStream.available();
            bytes = new byte[bytesExpected];
            int bytesActual = inputStream.read(bytes);
            if (bytesExpected != bytesActual) {
                throw new IOException("The number of actual bytes read is not equal to the number of bytes expected.");
            }
        }
        return bytes;
    }
}
