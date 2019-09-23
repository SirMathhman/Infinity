package com.meti.render.script;

enum Conditionals implements Conditional {
    LOOSE("=="),
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
