package com.meti.render;

import java.util.List;
import java.util.stream.Collectors;

public class Group implements Component {
    private final List<? extends Component> components;

    public Group(List<? extends Component> components) {
        this.components = components;
    }

    @Override
    public String render() {
        return components.stream()
                .map(Component::render)
                .collect(Collectors.joining());
    }
}