package com.meti.example;

public interface Binding<T> {
    void clear();

    T get();

    void set(T value);
}
