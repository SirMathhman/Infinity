package com.meti.render;

class SimpleElementContent implements ElementContent {
    private final StringBuilder builder = new StringBuilder();

    @Override
    public ElementContent append(String value) {
        builder.append(value);
        return this;
    }

    @Override
    public ElementContent append(Component value) {
        builder.append(value.render());
        return this;
    }

    @Override
    public String render() {
        return builder.toString();
    }
}
