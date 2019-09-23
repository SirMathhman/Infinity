package com.meti.render;

import java.util.Optional;
import java.util.function.Function;

public class SimpleBinding<T> implements Binding<T> {
    private T value;

    public SimpleBinding() {
        this(null);
    }

    public SimpleBinding(T value) {
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
    public Binding<T> set(T other) {
        this.value = other;
        return this;
    }

    @Override
    public <R> Binding<R> copy(Function<T, R> function) {
        return new SimpleBinding<>(function.apply(value));
    }
}
