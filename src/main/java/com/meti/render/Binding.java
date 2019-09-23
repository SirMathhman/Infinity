package com.meti.render;

import java.util.Optional;
import java.util.function.Function;

interface Binding<T> {
    T get();

    Optional<T> getOptionally();

    Binding<T> with(T other);

    <R> Binding<R> compute(Function<T, R> function);
}
