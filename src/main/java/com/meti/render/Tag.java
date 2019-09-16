package com.meti.render;

public class Tag implements Component {
    private final String content;
    private final Component attributes;

    public Tag(String content) {
        this(content, new EmptyComponent());
    }

    public Tag(String content, Component attributes) {
        this.content = content;
        this.attributes = attributes;
    }

    @Override
    public String render() {
        String renderedAttributes = attributes.render();
        String preRender = (renderedAttributes.isEmpty()) ? "" : " ";
        return "<" + content + preRender + renderedAttributes + ">";
    }
}
