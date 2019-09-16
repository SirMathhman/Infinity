package com.meti.render;

import java.util.ArrayList;
import java.util.List;

public class Element implements Component {
    private final String tagName;
    private final ElementContent content;

    public Element(String tagName) {
        this(tagName, new SimpleElementContent());
    }

    Element(String tagName, String value) {
        this(tagName, new SimpleElementContent().append(value));
    }

    Element(String tagName, ElementContent content) {
        this.tagName = tagName;
        this.content = content;
    }

    @Override
    public String render() {
        List<Component> components = new ArrayList<>();
        components.add(new Tag(tagName));
        components.add(content);
        components.add(new Tag("/" + tagName));
        return new Group(components).render();
    }
}
