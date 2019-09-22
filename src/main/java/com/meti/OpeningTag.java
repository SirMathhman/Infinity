package com.meti;

class OpeningTag implements Component {
    private final String tagName;
    private final Component attributes;

    OpeningTag(String tagName) {
        this(tagName, new Attributes());
    }

    OpeningTag(String tagName, Component attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
    public String render() {
        String attributes = this.attributes.render();
        String separator = (attributes.isEmpty()) ? "" : " ";
        return "<" + tagName + separator + attributes + ">";
    }
}
