package com.meti;

import com.meti.render.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Block {
    private final List<Component> components;

    public Block() {
        this(new ArrayList<>());
    }

    private Block(List<Component> components) {
        this.components = components;
    }

    private List<Component> getComponents() {
        return components;
    }

    void write(Component component) {
        getComponents().add(component);
    }

    String render() {
        return getComponents().stream()
                .map(Component::render)
                .collect(Collectors.joining());
    }
}
