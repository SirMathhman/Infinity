package com.meti.render.node;

public class SimpleInputBuilder implements InputBuilder {
    private final String id;
    private final InputType inputType;
    private final Object initialValue;
    private final String name;

    public SimpleInputBuilder() {
        this(null, InputType.HIDDEN, null, null);
    }

    private SimpleInputBuilder(String id, InputType inputType, Object initialValue, String name) {
        this.id = id;
        this.inputType = inputType;
        this.initialValue = initialValue;
        this.name = name;
    }

    @Override
    public InputBuilder withID(String id) {
        return new SimpleInputBuilder(id, inputType, initialValue, name);
    }

    @Override
    public InputBuilder withInputType(InputType inputType) {
        return new SimpleInputBuilder(id, inputType, initialValue, name);
    }

    @Override
    public InputBuilder withInitialValue(Object initialValue) {
        return new SimpleInputBuilder(id, inputType, initialValue, name);
    }

    @Override
    public Node build() {
        String name = (this.name == null) ? id : this.name;
        return new Input(inputType, id, name, initialValue);
    }
}