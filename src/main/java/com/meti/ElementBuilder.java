package com.meti;

interface ElementBuilder {
    ElementBuilder withTagName(String tagName);

    ElementBuilder withAttributes(Component attributes);

    ElementBuilder withChildren(Component... components);

    Component build();
}
