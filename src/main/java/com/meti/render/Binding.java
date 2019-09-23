package com.meti.render;

import java.util.Optional;
import java.util.function.Function;

public interface Binding<T> {
    T get();

    Optional<T> getOptionally();

    Binding<T> with(T other);

    default Binding<T> map(Function<T, T> function) {
        with(function.apply(get()));
        return this;
    }

    <R> Binding<R> copy(Function<T, R> function);
}
