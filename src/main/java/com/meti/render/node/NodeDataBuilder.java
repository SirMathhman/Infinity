package com.meti.render.node;

public interface NodeDataBuilder {
    NodeDataBuilder withID(String id);

    NodeData build();
}
