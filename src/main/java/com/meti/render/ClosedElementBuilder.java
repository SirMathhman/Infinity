package com.meti.render;

import java.util.HashMap;

public class ClosedElementBuilder implements ElementBuilder {
    private final Component attributes;
    private final ElementContent content;
    private final String tagName;

    public ClosedElementBuilder() {
        this("", new SimpleElementContent(), new MapAttributes(new HashMap<>()));
    }

    private ClosedElementBuilder(String tagName, ElementContent content, Component attributes) {
        this.tagName = tagName;
        this.content = content;
        this.attributes = attributes;
    }

    @Override
    public Component build() {
        return new ClosedElement(tagName, attributes, content);
    }

    @Override
    public ElementBuilder withAttributes(Component attributes) {
        return new ClosedElementBuilder(tagName, content, attributes);
    }

    @Override
    public ElementBuilder withContent(ElementContent content) {
        return new ClosedElementBuilder(tagName, content, attributes);
    }

    @Override
    public ElementBuilder withTagName(String tagName) {
        return new ClosedElementBuilder(tagName, content, attributes);
    }
}