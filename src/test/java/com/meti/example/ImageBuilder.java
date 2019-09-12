package com.meti.example;

import java.net.URL;

public interface ImageBuilder {
    Image build();

    ImageBuilder withAlt(String alt);

    ImageBuilder withDimensions(Dimensions dimensions);

    ImageBuilder withURL(URL url);
}
