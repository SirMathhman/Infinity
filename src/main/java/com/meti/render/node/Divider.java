package com.meti.render.node;

import com.meti.render.Component;
import com.meti.render.element.SimpleElementBuilder;

public class Divider extends Container {
    public Divider(Node... nodes) {
        super(nodes);
    }

    @Override
    public Component render() {
        return new SimpleElementBuilder()
                .withTagName("div")
                .withChildren(renderChildren())
                .build();
    }
}
