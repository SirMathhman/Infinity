package com.meti;

import com.meti.net.route.AssetRoute;
import com.meti.net.route.PathAssetRoute;
import com.meti.render.node.Image;
import com.meti.render.node.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImageTest {
    private Path root;
    private Path child;

    @BeforeEach
    void setUp() {
        root = Paths.get("test");
        child = root.resolve("child.png");
    }

    @Test
    void construct() {
        AssetRoute<Path> pathAssetRoute = new PathAssetRoute(root, "/images");
        String childWebPath = pathAssetRoute.buildWebPath(child);
        Node image = new Image(childWebPath, "Some Alternate Text");
        assertEquals("<img alt=\"Some Alternate Text\" src=\"/images/child.png\">", image.render().render());
    }
}
