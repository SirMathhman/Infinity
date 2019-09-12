package com.meti.example;

import com.meti.render.*;

import java.net.URL;

class Image implements Node {
    private final String alt;
    private final Dimensions dimensions;
    private final URL url;

    Image(String alt, Dimensions dimensions, URL url) {
        this.alt = alt;
        this.dimensions = dimensions;
        this.url = url;
    }

    @Override
    public Component render() {
        Attributes attributes = new MapAttributes(
                "src", url.toString(),
                "alt", alt,
                "width", dimensions.width().get().render(),
                "height", dimensions.height().get().render());
        return new OpenElement(new AttributeTag("img", attributes));
    }
}
