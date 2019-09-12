package com.meti.example;

import com.meti.util.Binding;

public interface Events {
    Binding<FunctionRef> onMouseDown();

    Binding<FunctionRef> onMouseMove();

    Binding<FunctionRef> onMouseUp();
}
