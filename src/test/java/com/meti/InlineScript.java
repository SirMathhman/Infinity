package com.meti;

import com.meti.render.Component;
import com.meti.render.element.SimpleElementBuilder;
import com.meti.render.node.Node;

class InlineScript implements Node {
    private final String content;

    InlineScript(String content) {
        this.content = content;
    }

    @Override
    public Component render() {
        return new SimpleElementBuilder()
                .withTagName("script")
                .withChildren(() -> content)
                .build();
    }
}
