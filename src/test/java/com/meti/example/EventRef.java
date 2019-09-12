package com.meti.example;

import com.meti.render.Component;

public interface EventRef extends Ref {
    Vector2 coordinates();

    Component preventDefault();
}
