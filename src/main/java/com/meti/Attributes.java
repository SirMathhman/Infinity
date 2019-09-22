package com.meti;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Attributes implements Component {
    private final Map<String, String> values;

    Attributes() {
        this(new HashMap<>());
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
