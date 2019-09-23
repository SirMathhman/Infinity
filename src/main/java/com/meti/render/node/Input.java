package com.meti.render.node;

import com.meti.render.Component;
import com.meti.render.element.Attributes;
import com.meti.render.element.OpeningTag;

import java.util.HashMap;
import java.util.Map;

class Input implements Node {
    private final String name;
    private final Object initialValue;
    private final InputType type;
    private final String id;

    Input(InputType type, String id, String name, Object initialValue) {
        this.name = name;
        this.initialValue = initialValue;
        this.type = type;
        this.id = id;
    }

    @Override
    public Component render() {
        Map<String, String> attributeMap = new HashMap<>();
        if (id != null) attributeMap.put("id", id);
        if (name != null) attributeMap.put("name", name);
        if (type != null) attributeMap.put("type", type.name());
        if (initialValue != null) attributeMap.put("value", initialValue.toString());
        Component attributes = new Attributes(attributeMap);
        return new OpeningTag("input", attributes);
    }
}
