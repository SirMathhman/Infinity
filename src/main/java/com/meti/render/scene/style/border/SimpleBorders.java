package com.meti.render.scene.style.border;

import com.meti.render.Component;
import com.meti.render.scene.style.Direction;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class SimpleBorders implements Borders {
    private final Map<Direction, Component> borders = new EnumMap<>(Direction.class);

    @Override
    public Map<String, String> build() {
        return null;
    }

    @Override
    public void setAll(Component border) {
        Arrays.stream(Direction.values()).forEach(value -> borders.put(value, border));
    }
}
