package com.meti.render;

import java.util.Map;
import java.util.stream.Collectors;

public class MapAttributes implements Component {
    private final Map<String, String> attributes;

    public MapAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String render() {
        return attributes.keySet().stream()
                .map(s -> s + "=\"" + attributes.get(s) + "\"")
                .collect(Collectors.joining(" "));
    }
}
