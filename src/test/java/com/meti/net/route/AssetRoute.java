package com.meti.net.route;

import com.meti.net.Request;
import com.meti.net.response.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readAllBytes;

public class AssetRoute implements Route {
    private final Path rootDirectory;

    public AssetRoute(Path rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public boolean canProcess(Request request) {
        Path actual = buildPath(request);
        return Files.exists(actual);
    }

    private Path buildPath(Request request) {
        String path = request.getPath();
        String[] args = path.replace("/assets/", "")
                .split("/");
        Path actual = rootDirectory;
        for (String arg : args) {
            actual = actual.resolve(arg);
        }
        return actual;
    }

    @Override
    public Response process(Request request) {
        try {
            Path path = buildPath(request);
            ResponseType type = new URIType(path.toUri());
            byte[] bytes = readAllBytes(path);
            return new ByteResponse(DefaultCode.OK, type, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
