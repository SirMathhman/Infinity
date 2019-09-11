package com.meti.render;

import java.util.function.Supplier;

public interface Attributes extends Component {
    default void put(String name, String value) {
        put(name, () -> value);
    }

    void put(String name, Supplier<String> value);
}
