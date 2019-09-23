package com.meti.render.node;

public interface InputBuilder {
    InputBuilder withID(String id);

    InputBuilder withInputType(InputType inputType);

    InputBuilder withInitialValue(Object initialValue);

    Node build();
}
