package com.meti.util;

public class SimpleBinding<T> implements Binding<T> {
    private T value = null;

    SimpleBinding(T value) {
        this.value = value;
    }

    public SimpleBinding() {
    }

    @Override
    public void clear() {
        this.value = null;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public void set(T value) {
        this.value = value;
    }
}
