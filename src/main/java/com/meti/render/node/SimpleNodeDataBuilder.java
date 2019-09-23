package com.meti.render.node;

public class SimpleNodeDataBuilder implements NodeDataBuilder {
    private String id;

    @Override
    public NodeDataBuilder withID(String id) {
        this.id = id;
        return this;
    }

    @Override
    public NodeData build() {
        return new SimpleNodeData(id);
    }
}