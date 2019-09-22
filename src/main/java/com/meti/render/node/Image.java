package com.meti.render.node;

import com.meti.render.Component;
import com.meti.render.element.Attributes;
import com.meti.render.element.OpeningTag;

import java.util.HashMap;
import java.util.Map;

public class Image implements Node {
    private final String source;
    private final String alternateText;

    public Image(String source, String alternateText) {
        this.source = source;
        this.alternateText = alternateText;
    }

    @Override
    public Component render() {
        Map<String, String> attributeMap = new HashMap<>();
        attributeMap.put("alt", alternateText);
        attributeMap.put("src", source);
        Component attributes = new Attributes(attributeMap);
        return new OpeningTag("img", attributes);
    }
}
