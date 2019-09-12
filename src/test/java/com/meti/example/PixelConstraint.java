package com.meti.example;

class PixelConstraint implements Constraint {
    private final int value;

    public PixelConstraint(int value) {
        this.value = value;
    }

    @Override
    public String render() {
        return value + "px";
    }
}
