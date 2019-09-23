package com.meti.render.node;

import com.meti.net.Method;
import com.meti.net.route.PathRoute;

import java.util.Collection;

public class FormBuilder {
    private NodeData nodeData;
    private PathRoute action;
    private Method method;
    private Collection<Node> children;

    public FormBuilder withNodeData(NodeData nodeData) {
        this.nodeData = nodeData;
        return this;
    }

    public FormBuilder withAction(PathRoute action) {
        this.action = action;
        return this;
    }

    public FormBuilder withMethod(Method method) {
        this.method = method;
        return this;
    }

    public FormBuilder withChildren(Collection<Node> children) {
        this.children = children;
        return this;
    }

    public Form build() {
        return new Form(nodeData, action, method, children);
    }
}