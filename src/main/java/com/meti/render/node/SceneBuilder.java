package com.meti.render.node;

import com.meti.render.Component;

import java.nio.charset.Charset;
import java.util.Locale;

public interface SceneBuilder {
    SceneBuilder withTitle(String title);

    SceneBuilder withCharSet(Charset charSet);

    SceneBuilder withLocale(Locale locale);

    SceneBuilder withRoot(Component root);

    Node build();
}
