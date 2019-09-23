package com.meti.render.node;

import java.nio.charset.Charset;
import java.util.Locale;

public class SimpleSceneBuilder implements SceneBuilder {
    private final String title;
    private final Charset charSet;
    private final Locale locale;
    private final Node root;

    public SimpleSceneBuilder() {
        this("", Charset.defaultCharset(), Locale.getDefault(), null);
    }

    private SimpleSceneBuilder(String title, Charset charSet, Locale locale, Node root) {
        this.title = title;
        this.charSet = charSet;
        this.locale = locale;
        this.root = root;
    }

    @Override
    public SceneBuilder withTitle(String title) {
        return new SimpleSceneBuilder(title, charSet, locale, root);
    }

    @Override
    public SceneBuilder withCharSet(Charset charSet) {
        return new SimpleSceneBuilder(title, charSet, locale, root);
    }

    @Override
    public SceneBuilder withLocale(Locale locale) {
        return new SimpleSceneBuilder(title, charSet, locale, root);
    }

    @Override
    public SceneBuilder withRoot(Node root) {
        return new SimpleSceneBuilder(title, charSet, locale, root);
    }

    @Override
    public Node build() {
        return new Scene(title, charSet, locale, root);
    }
}