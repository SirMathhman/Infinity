package com.meti;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

class URLUtils {
    static byte[] readAllBytes(URL url) throws IOException {
        byte[] bytes;
        try (InputStream stream = url.openStream()) {
            int expectedQuantity = stream.available();

            bytes = new byte[expectedQuantity];
            int actualQuantity = stream.read(bytes);
            assert expectedQuantity == actualQuantity;
        }
        return bytes;
    }
}
