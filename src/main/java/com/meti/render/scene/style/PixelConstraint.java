package com.meti.render.scene.style;

public class PixelConstraint implements Constraint {
    private final int value;

    public PixelConstraint(int value) {
        this.value = value;
    }

    @Override
    public String render() {
        return value + "px";
    }
}
