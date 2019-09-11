package com.meti.server.route;

import com.meti.server.context.Context;
import com.meti.server.response.InlineResponse;
import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.response.ResponseTypes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.newInputStream;

public class AssetRoute implements Route {
    private final Path internalPath;
    private final String virtualPath;

    public AssetRoute(Path internalPath, String virtualPath) {
        this.internalPath = internalPath;
        this.virtualPath = virtualPath;
    }

    @Override
    public boolean canProcess(Context context) {
        return exists(buildPath(context));
    }

    @Override
    public Response process(Context context) {
        try {
            return processExceptionally(context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Response processExceptionally(Context context) throws IOException {
        Path asset = buildPath(context);
        byte[] bytes = readAllBytes(asset);
        return new InlineResponse(ResponseCodes.OK, ResponseTypes.get(asset), bytes);
    }

    private byte[] readAllBytes(Path asset) throws IOException {
        byte[] bytes;
        try (InputStream inputStream = newInputStream(asset)) {
            bytes = inputStream.readAllBytes();
        }
        return bytes;
    }

    private Path buildPath(Context context) {
        String path = context.getPath();
        String child = path.replace(virtualPath + "/", "");
        return internalPath.resolve(child);
    }
}
