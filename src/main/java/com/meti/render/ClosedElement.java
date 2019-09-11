package com.meti.render;

public class ClosedElement implements Component {
    private final Component content;
    private final String tagName;

    public ClosedElement(String tagName, String content) {
        this(tagName, () -> content);
    }

    private ClosedElement(String tagName, Component content) {
        this.tagName = tagName;
        this.content = content;
    }

    public static Component compose(String tagName, Component... content) {
        return new ClosedElement(tagName, Component.compose(content));
    }

    @Override
    public String render() {
        return "<" + tagName + ">" + content.render() + "</" + tagName + ">";
    }
}
