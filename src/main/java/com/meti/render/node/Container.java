package com.meti.render.node;

import com.meti.render.Component;

import java.util.Arrays;
import java.util.Collection;

abstract class Container implements Node {
    private final Collection<Node> children;

    Container(Node... nodes) {
        this(Arrays.asList(nodes));
    }

    Container(Collection<Node> children) {
        this.children = children;
    }

    Component[] renderChildren() {
        return children.stream()
                .map(Node::render)
                .toArray(Component[]::new);
    }
}
