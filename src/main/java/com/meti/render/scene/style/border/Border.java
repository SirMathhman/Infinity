package com.meti.render.scene.style.border;

import com.meti.render.Component;
import com.meti.render.scene.style.Color;
import com.meti.render.scene.style.Constraint;

import java.util.Locale;

public class Border implements Component {
    private final Color color;
    private final Constraint constraint;
    private final BorderType type;

    public Border(BorderType type, Color color, Constraint constraint) {
        this.type = type;
        this.color = color;
        this.constraint = constraint;
    }

    @Override
    public String render() {
        return type.name().toLowerCase(Locale.ENGLISH) + " " + color.render() + " " + constraint.render();
    }
}
