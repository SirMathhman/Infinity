package com.meti.render;

public interface ElementBuilder {
    Component build();

    ElementBuilder withAttributes(Component attributes);

    ElementBuilder withContent(ElementContent content);

    ElementBuilder withTagName(String tagName);
}
