package com.meti.render;

import java.util.ArrayList;
import java.util.List;

public class ClosedElement implements Component {
    private final String tagName;
    private final ElementContent content;

    public ClosedElement(String tagName, ElementContent content) {
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
