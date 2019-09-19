package com.meti.server;

import com.meti.response.InlineResponse;
import com.meti.response.Response;
import com.meti.response.ResponseType;

import java.io.IOException;
import java.nio.file.Path;

import static com.meti.response.ResponseCodes.INTERNAL_SERVER_ERROR;
import static com.meti.response.ResponseCodes.OK;
import static com.meti.response.ResponseTypes.PLAINTEXT;
import static com.meti.response.ResponseTypes.fromPath;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.readAllBytes;

public class AssetRoute implements Route {
    private final String virtualPath;
    private final Path directory;

    public AssetRoute(String virtualPath, Path directory) {
        this.virtualPath = virtualPath;
        this.directory = directory;
    }

    private Path buildPath(Context context) {
        String url = context.getPath();
        String[] result = url.replace(virtualPath + "/", "")
                .split("/");
        Path currentPath = directory;
        for (String s : result) {
            currentPath = currentPath.resolve(s);
        }
        return currentPath;
    }

    @Override
    public boolean canProcess(Context context) {
        return exists(buildPath(context));
    }

    @Override
    public Response process(Context context) {
        try {
            Path path = buildPath(context);
            byte[] bytes = readAllBytes(path);
            ResponseType responseType = fromPath(path);
            return new InlineResponse(OK, responseType, bytes);
        } catch (IOException e) {
            byte[] eMessage = e.getMessage().getBytes();
            return new InlineResponse(INTERNAL_SERVER_ERROR, PLAINTEXT, eMessage);
        }
    }
}
