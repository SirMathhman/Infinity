package com.meti.render.element;

import com.meti.render.Component;

public class SimpleElementBuilder implements ElementBuilder {
    private final String tagName;
    private final Component attributes;
    private final Component[] components;

    public SimpleElementBuilder() {
        this("", new Attributes(), new Component[0]);
    }

    private SimpleElementBuilder(String tagName, Component attributes, Component[] components) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.components = components;
    }

    @Override
    public ElementBuilder withTagName(String tagName) {
        return new SimpleElementBuilder(tagName, attributes, components);
    }

    @Override
    public ElementBuilder withAttributes(Component attributes) {
        return new SimpleElementBuilder(tagName, attributes, components);
    }

    @Override
    public ElementBuilder withChildren(Component... components) {
        return new SimpleElementBuilder(tagName, attributes, components);
    }

    @Override
    public Component build() {
        return new Element(tagName, attributes, components);
    }
}