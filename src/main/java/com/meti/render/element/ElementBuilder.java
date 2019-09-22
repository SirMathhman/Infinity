package com.meti.render.element;

import com.meti.render.Component;

public interface ElementBuilder {
    ElementBuilder withTagName(String tagName);

    ElementBuilder withAttributes(Component attributes);

    ElementBuilder withChildren(Component... components);

    Component build();
}
