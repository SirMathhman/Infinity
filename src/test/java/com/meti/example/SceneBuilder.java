package com.meti.example;

import com.meti.render.scene.Node;

import java.nio.charset.Charset;

public interface SceneBuilder {
    Scene build();

    SceneBuilder withCharset(Charset utf8);

    SceneBuilder withLanguage(String language);

    SceneBuilder withRoot(Node root);

    SceneBuilder withTitle(String title);
}
