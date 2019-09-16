package com.meti.render;

import java.util.HashMap;

public class ClosedElementBuilder {
    private String tagName;
    private ElementContent content;
    private Component attributes;

    public ClosedElementBuilder() {
        this("", new SimpleElementContent(), new MapAttributes(new HashMap<>()));
    }

    public ClosedElementBuilder(String tagName, ElementContent content, Component attributes) {
        this.tagName = tagName;
        this.content = content;
        this.attributes = attributes;
    }

    public ClosedElementBuilder withTagName(String tagName) {
        return new ClosedElementBuilder(tagName, content, attributes);
    }

    public ClosedElementBuilder withContent(ElementContent content) {
        return new ClosedElementBuilder(tagName, content, attributes);
    }

    public ClosedElement build() {
        return new ClosedElement(tagName, attributes, content);
    }

    public ClosedElementBuilder withAttributes(Component attributes) {
        return new ClosedElementBuilder(tagName, content, attributes);
    }
}