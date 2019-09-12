package com.meti.util;

import java.util.Optional;

public interface Binding<T> {
    void clear();

    default Optional<T> getOptionally() {
        return Optional.ofNullable(get());
    }

    T get();

    void set(T value);
}
