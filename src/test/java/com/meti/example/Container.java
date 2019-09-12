package com.meti.example;

import com.meti.util.Binding;

public interface Container extends Node {
    void addAll(Node... nodes);

    Borders border();

    Dimensions dimensions();

    Binding<PositionType> position();
}
