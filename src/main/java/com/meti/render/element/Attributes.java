package com.meti.render.element;

import com.meti.render.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Attributes implements Component {
    private final Map<String, String> values;

    public Attributes(String... values) {
        this(new HashMap<>());
        if (values.length % 2 == 1) throw new IllegalArgumentException("Argument length must be even.");
        for (int i = 0; i < values.length; i += 2) {
            this.values.put(values[i], values[i + 1]);
        }
    }

    public Attributes(Map<String, String> values) {
        this.values = values;
    }

    @Override
    public String render() {
        return values.keySet()
                .stream()
                .sorted()
                .map(s -> s + "=\"" + values.get(s) + "\"")
                .collect(Collectors.joining(" "));
    }
}
