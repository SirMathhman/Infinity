package com.meti;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Attributes implements Component {
    private final Map<String, String> values;

    Attributes(String... values) {
        this(new HashMap<>());
        if (values.length % 2 == 1) throw new IllegalArgumentException("Argument length must be even.");
        for (int i = 0; i < values.length; i += 2) {
            this.values.put(values[i], values[i + 1]);
        }
    }

    Attributes(Map<String, String> values) {
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
