package com.meti.render.script;

public enum Conditionals implements Conditional {
    STRICT("===");
    private final String value;

    Conditionals(String value) {
        this.value = value;


    }

    @Override
    public String getValue() {
        return value;
    }
}
