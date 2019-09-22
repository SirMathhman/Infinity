package com.meti.render.element;

import com.meti.render.Component;

public class Element extends Group {
    private final Component closingTag;
    private final OpeningTag openingTag;

    Element(String tagName, Component attributes, Component... components) {
        super(components);
        this.openingTag = new OpeningTag(tagName, attributes);
        this.closingTag = new ClosingTag(tagName);
    }

    @Override
    public String render() {
        return openingTag.render() + super.render() + closingTag.render();
    }
}
