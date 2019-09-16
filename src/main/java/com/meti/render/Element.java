package com.meti.render;

import java.util.ArrayList;
import java.util.List;

public class Element implements Component {
    private final String tagName;

    public Element(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String render() {
        List<Component> components = new ArrayList<>();
        components.add(new Tag(tagName));
        components.add(new Tag("/" + tagName));
        return new Group(components).render();
    }
}
