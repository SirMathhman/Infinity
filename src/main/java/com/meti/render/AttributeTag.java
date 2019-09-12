package com.meti.render;

public class AttributeTag implements Tag {
    private final Attributes attributes;
    private final String tagName;

    public AttributeTag(String tagName, Attributes attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
    public String renderClosing() {
        return "</" + tagName + ">";
    }

    @Override
    public String renderOpening() {
        String renderedAttributes = attributes.render();
        String formattedAttributes = (renderedAttributes.isBlank()) ? "" : " " +
                renderedAttributes;
        return "<" + tagName + formattedAttributes + ">";
    }
}
