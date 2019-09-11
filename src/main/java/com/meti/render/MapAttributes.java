package com.meti.render;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class MapAttributes implements Attributes {
    private final Map<String, Supplier<String>> internalMap = new HashMap<>();

    @Override
    public void put(String name, Supplier<String> value) {
        internalMap.put(name, value);
    }

    @Override
    public String render() {
        return internalMap.keySet()
                .stream()
                .map(s -> s + "=\"" + internalMap.get(s).get() + "\"")
                .collect(Collectors.joining(" "));
    }
}
