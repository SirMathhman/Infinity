package com.meti;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

class Group implements Component {
    private final Collection<Component> components;

    public Group(Component... components) {
        this.components = Arrays.asList(components);
    }

    @Override
    public String render() {
        return components.stream()
                .map(Component::render)
                .collect(Collectors.joining());
    }
}
