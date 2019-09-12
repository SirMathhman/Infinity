package com.meti.example;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

class SimpleBorders implements Borders {
    private final Map<Direction, Border> borders = new EnumMap<>(Direction.class);

    @Override
    public Map<String, String> build() {
        return null;
    }

    @Override
    public void setAll(Border border) {
        Arrays.stream(Direction.values()).forEach(value -> borders.put(value, border));
    }
}
