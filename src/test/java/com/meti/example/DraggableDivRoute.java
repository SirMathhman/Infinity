package com.meti.example;

import com.meti.render.scene.Node;
import com.meti.server.context.Request;
import com.meti.server.response.Response;
import com.meti.server.response.ResponseCodes;
import com.meti.server.response.StringResponse;
import com.meti.server.route.Route;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

class DraggableDivRoute implements Route {
    @Override
    public Response process(Request request) {
        try {
            Node content = new DraggableDivContent().build();
            Node root = new Group(List.of(content));
            SceneBuilder builder = new SimpleSceneBuilder();
            Scene scene = builder.withRoot(root)
                    .withLanguage(Locale.getDefault().getLanguage())
                    .withCharset(StandardCharsets.UTF_8)
                    .withTitle("Draggable Div")
                    .build();
            return new SceneResponse(ResponseCodes.OK, scene);
        } catch (MalformedURLException e) {
            return new StringResponse(ResponseCodes.OK, e.getLocalizedMessage());
        }
    }
}
