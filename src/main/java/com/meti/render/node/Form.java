package com.meti.render.node;

import com.meti.net.route.PathRoute;
import com.meti.net.route.RouteMethod;
import com.meti.render.Component;
import com.meti.render.element.Attributes;
import com.meti.render.element.SimpleElementBuilder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Form extends Container {
    private final PathRoute action;
    private final RouteMethod method;

    public Form(PathRoute action, RouteMethod method, Collection<Node> children) {
        super(children);
        this.action = action;
        this.method = method;
    }

    @Override
    public Component render() {
        Map<String, String> attributeMap = new HashMap<>();
        attributeMap.put("action", action.getPath());
        attributeMap.put("method", method.name());
        return new SimpleElementBuilder()
                .withTagName("form")
                .withChildren(renderChildren())
                .withAttributes(new Attributes(attributeMap))
                .build();
    }

}
