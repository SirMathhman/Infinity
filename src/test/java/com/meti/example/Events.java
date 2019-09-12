package com.meti.example;

public interface Events {
    Binding<FunctionRef> onMouseDown();

    Binding<FunctionRef> onMouseMove();

    Binding<FunctionRef> onMouseUp();
}
