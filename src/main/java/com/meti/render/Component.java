package com.meti.render;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Component extends Supplier<String> {
    static Component compose(Component... others) {
        return compose(Arrays.stream(others));
    }

    static Component compose(Stream<? extends Component> stream) {
        return () -> stream
                .map(Component::render)
                .collect(Collectors.joining());
    }

    String render();

    @Override
    default String get() {
        return render();
    }
}
