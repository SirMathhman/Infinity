package com.meti.render.scene.style;

import com.meti.util.Binding;
import com.meti.util.SimpleBinding;

public class SimpleDimensions implements Dimensions {
    private final Binding<Constraint> height = new SimpleBinding<>();
    private final Binding<Constraint> width = new SimpleBinding<>();

    public SimpleDimensions() {
        this(null, null);
    }

    public SimpleDimensions(Constraint width, Constraint height) {
        this.width.set(width);
        this.height.set(height);
    }

    @Override
    public Binding<Constraint> height() {
        return height;
    }

    @Override
    public void set(Constraint width, Constraint height) {
        this.width.set(width);
        this.height.set(height);
    }

    @Override
    public Binding<Constraint> width() {
        return width;
    }
}
