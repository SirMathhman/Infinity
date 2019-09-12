package com.meti.render.scene.container;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class MapStyles implements Styles {
    private final Map<String, String> values;

    MapStyles(String... values) {
        this(new HashMap<>());
        int length = values.length;
        if (length % 2 != 0) throw new IllegalArgumentException("Odd number of arguments.");
        for (int i = 0; i < length; i += 2) {
            this.values.put(values[i], values[i + 1]);
        }
    }

    MapStyles(Map<String, String> values) {
        this.values = values;
    }

    @Override
    public void put(String name, String value) {
        values.put(name, value);
    }

    @Override
    public String render() {
        return values.keySet()
                .stream()
                .sorted()
                .map(s -> s + ":" + values.get(s))
                .collect(Collectors.joining(";"));
    }
}