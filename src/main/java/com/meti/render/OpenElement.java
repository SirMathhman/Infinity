package com.meti.render;

public class OpenElement implements Component {
    private final Tag tag;

    public OpenElement(String tagName) {
        this(new SimpleTag(tagName));
    }

    public OpenElement(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String render() {
        return tag.renderOpening();
    }
}
