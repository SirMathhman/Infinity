package com.meti.example;

import com.meti.render.scene.style.Constraint;
import com.meti.render.scene.style.PixelConstraint;

import java.net.MalformedURLException;
import java.net.URL;

class DraggableImage implements NodeBuilder {
    @Override
    public Node build() throws MalformedURLException {
        Constraint imageSize = new PixelConstraint(100);
        return new SimpleImageBuilder()
                .withAlt("A Tree")
                .withDimensions(new SimpleDimensions(imageSize, imageSize))
                .withURL(new URL("https://media.gettyimages.com/photos/tree-against-white-background-picture" +
                        "-id887508916?s" +
                        "=612x612"))
                .build();
    }
}
