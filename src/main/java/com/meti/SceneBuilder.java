package com.meti;

import java.nio.charset.Charset;
import java.util.Locale;

interface SceneBuilder {
    SceneBuilder withTitle(String title);

    SceneBuilder withCharSet(Charset charSet);

    SceneBuilder withLocale(Locale locale);

    SceneBuilder withRoot(Component root);

    Node build();
}
