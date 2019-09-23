package com.meti.render;

import java.util.Optional;
import java.util.function.Function;

public interface Binding<T> {
    T get();

    Optional<T> getOptionally();

    default T swap(T other) {
        T previous = get();
        set(other);
        return previous;
    }

    Binding<T> set(T other);

    <R> Binding<R> copy(Function<T, R> function);
}
