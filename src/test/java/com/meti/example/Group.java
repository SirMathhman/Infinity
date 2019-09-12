package com.meti.example;

import com.meti.render.Component;
import com.meti.render.scene.Node;

import java.util.List;

class Group implements Node {
    private final List<? extends Node> children;

    public Group(List<? extends Node> children) {
        this.children = children;
    }

    @Override
    public Component render() {
        return Component.compose(children.stream()
                .map(Node::render));
    }
}
