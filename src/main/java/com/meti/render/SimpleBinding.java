package com.meti.render;

import java.util.Optional;
import java.util.function.Function;

class SimpleBinding<T> implements Binding<T> {
    private final T value;

    SimpleBinding(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public Optional<T> getOptionally() {
        return Optional.ofNullable(value);
    }

    @Override
    public Binding<T> with(T other) {
        return new SimpleBinding<>(other);
    }

    @Override
    public <R> Binding<R> compute(Function<T, R> function) {
        return new SimpleBinding<>(function.apply(value));
    }
}
