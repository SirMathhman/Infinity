package com.meti.render;

public class ClosedElement implements Component {
    private final Tag tag;
    private final Component content;

    public ClosedElement(Tag tag, String content) {
        this(tag, () -> content);
    }

    public ClosedElement(Tag tag, Component content) {
        this.tag = tag;
        this.content = content;
    }

    public static Component compose(Tag tag, Component... content) {
        return new ClosedElement(tag, Component.compose(content));
    }

    @Override
    public String render() {
        return tag.renderOpening() + content.render() + tag.renderClosing();
    }
}
