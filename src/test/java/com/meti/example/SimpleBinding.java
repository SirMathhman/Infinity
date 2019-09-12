package com.meti.example;

class SimpleBinding<T> implements Binding<T> {
    private T value;

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
