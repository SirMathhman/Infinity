package com.meti;

import java.util.ArrayList;
import java.util.List;

class Element implements Component {
    private final String tagName;

    Element(String tagName) {
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
