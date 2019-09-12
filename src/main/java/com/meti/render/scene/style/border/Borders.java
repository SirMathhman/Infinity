package com.meti.render.scene.style.border;

import com.meti.render.Component;

import java.util.Map;

public interface Borders {
    Map<String, String> build();

    void setAll(Component border);
}
