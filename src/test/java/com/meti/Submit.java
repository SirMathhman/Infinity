package com.meti;

import com.meti.render.Component;
import com.meti.render.element.Attributes;
import com.meti.render.element.OpeningTag;
import com.meti.render.node.Node;

import java.util.HashMap;
import java.util.Map;

class Submit implements Node {
    @Override
    public Component render() {
        Map<String, String> attributeMap = new HashMap<>();
        attributeMap.put("type", "submit");
        return new OpeningTag("input", new Attributes(attributeMap));
    }
}
