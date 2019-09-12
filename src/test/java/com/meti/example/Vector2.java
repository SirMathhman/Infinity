package com.meti.example;

import java.util.function.Function;

public interface Vector2 {
    void compute(Function<Vector2, Vector2> applicator);

    void set(Vector2 other);

    Vector2 subtract(Vector2 coordinates);
}
