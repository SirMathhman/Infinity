package com.meti.example;

public interface Container extends Node {
    void addAll(Node... nodes);

    Borders border();

    Dimensions dimensions();

    Binding<PositionType> position();
}
