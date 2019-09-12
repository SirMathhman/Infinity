package com.meti.example;

import java.net.URL;

class SimpleImageBuilder implements ImageBuilder {
    private final String alt;
    private final Dimensions dimensions;
    private final URL url;

    public SimpleImageBuilder(String alt, Dimensions dimensions, URL url) {
        this.alt = alt;
        this.dimensions = dimensions;
        this.url = url;
    }

    @Override
    public Image build() {
        return new Image(alt, dimensions, url);
    }

    @Override
    public ImageBuilder withAlt(String alt) {
        return new SimpleImageBuilder(alt, dimensions, url);
    }

    @Override
    public ImageBuilder withDimensions(Dimensions dimensions) {
        return new SimpleImageBuilder(alt, dimensions, url);
    }

    @Override
    public ImageBuilder withURL(URL url) {
        return new SimpleImageBuilder(alt, dimensions, url);
    }
}
