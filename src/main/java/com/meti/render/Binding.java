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

    default Binding<T> map(Function<T, T> function) {
        set(function.apply(get()));
        return this;
    }

    <R> Binding<R> copy(Function<T, R> function);
}
