package com.meti.render;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class MapAttributes implements Attributes {
    private final Map<String, Supplier<String>> internalMap = new HashMap<>();

    public MapAttributes(String... values) {
        int length = values.length;
        if (length % 2 != 0) throw new IllegalArgumentException("Odd number of arguments.");
        for (int i = 0; i < length; i += 2) {
            put(values[i], values[i + 1]);
        }
    }

    @Override
    public void put(String name, String value) {
        put(name, () -> value);
    }

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
