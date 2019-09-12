package com.meti.example;

import com.meti.util.Binding;

public interface Dimensions {
    Binding<Constraint> height();

    void set(Constraint width, Constraint height);

    Binding<Constraint> width();
}
