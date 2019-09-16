package com.meti.render;

import java.util.HashMap;

class OpenElement implements Component {
    private final String tagName;
    private final Component attributes;

    OpenElement(String tagName) {
        this(tagName, new MapAttributes(new HashMap<>()));
    }

    OpenElement(String tagName, Component attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
    public String render() {
        return new Tag(tagName, attributes).render();
    }
}
