package com.meti.render.scene.style.border;

import com.meti.render.Component;
import com.meti.render.scene.style.Color;
import com.meti.render.scene.style.Constraint;

public class Border implements Component {
    private final Color color;
    private final Constraint constraint;
    private final BorderType solid;

    public Border(BorderType solid, Color color, Constraint constraint) {
        this.solid = solid;
        this.color = color;
        this.constraint = constraint;
    }

    @Override
    public String render() {
        return solid.name() + " " + color.render() + " " + constraint.render();
    }
}
