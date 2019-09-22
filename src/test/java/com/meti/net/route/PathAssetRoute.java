package com.meti.net.route;

import com.meti.net.Request;
import com.meti.net.response.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readAllBytes;

public class PathAssetRoute implements AssetRoute<Path> {
    private final Path serverPath;
    private final String webPath;

    public PathAssetRoute(Path serverPath, String webPath) {
        this.serverPath = serverPath;
        this.webPath = webPath;
    }

    @Override
    public String buildWebPath(Path other) {
        Path relativeOther = serverPath.relativize(other);
        int nameCount = relativeOther.getNameCount();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nameCount; i++) {
            builder.append("/");
            builder.append(relativeOther.getName(i));
        }
        return webPath + builder.toString();
    }

    @Override
    public boolean canProcess(Request request) {
        Path actual = buildPath(request);
        return Files.exists(actual);
    }

    private Path buildPath(Request request) {
        String path = request.getPath();
        String[] args = path.replace(webPath + "/", "")
                .split("/");
        Path actual = serverPath;
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
