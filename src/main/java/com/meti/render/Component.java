package com.meti.render;

import java.util.Arrays;
import java.util.stream.Collectors;

public interface Component {
    static Component compose(Component... others) {
        return () -> Arrays.stream(others)
                .map(Component::render)
                .collect(Collectors.joining());
    }

    String render();
}
