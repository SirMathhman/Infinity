package com.meti.example;

public interface Dimensions {
    Binding<Constraint> height();

    void set(Constraint width, Constraint height);

    Binding<Constraint> width();
}
