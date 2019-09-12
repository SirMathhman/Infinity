package com.meti.example;

import com.meti.render.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Styles implements Component {
    private final Map<String, String> values = new HashMap<>();

    public Styles(String... values) {
        int length = values.length;
        if (length % 2 != 0) throw new IllegalArgumentException("Odd number of arguments.");
        for (int i = 0; i < length; i += 2) {
            this.values.put(values[i], values[i + 1]);
        }
    }

    public void put(String name, String value) {
        values.put(name, value);
    }

    @Override
    public String render() {
        return values.keySet()
                .stream()
                .map(s -> s + ":" + values.get(s))
                .collect(Collectors.joining(";"));
    }
}