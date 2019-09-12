package com.meti.render.scene.container;

import com.meti.render.scene.Node;
import com.meti.render.scene.style.Dimensions;
import com.meti.render.scene.style.border.Borders;
import com.meti.util.Binding;

public interface Container extends Node {
    void addAll(Node... nodes);

    Borders border();

    Dimensions dimensions();

    Binding<PositionType> position();
}
