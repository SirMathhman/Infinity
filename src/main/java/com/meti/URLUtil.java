package com.meti;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

final class URLUtil {
    private URLUtil() {
    }

    static byte[] readDataFromURL(URL url) throws IOException {
        byte[] data;
        try (InputStream inputStream = url.openStream()) {
            data = inputStream.readAllBytes();
        }
        return data;
    }
}
