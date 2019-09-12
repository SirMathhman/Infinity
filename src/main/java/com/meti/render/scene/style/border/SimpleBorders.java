package com.meti.render.scene.style.border;

import com.meti.render.Component;
import com.meti.render.scene.style.Direction;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleBorders implements Borders {
    private final Map<Direction, Component> borders = new EnumMap<>(Direction.class);

    @Override
    public Map<String, String> build() {
        return new TreeMap<>(borders.keySet()
                .stream()
                .collect(Collectors.toMap(direction -> "border-" + direction.name().toLowerCase(Locale.ENGLISH),
                        direction -> borders.get(direction).render())));
    }

    @Override
    public void setAll(Component border) {
        Arrays.stream(Direction.values()).forEach(value -> borders.put(value, border));
    }
}
