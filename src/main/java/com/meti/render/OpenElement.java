package com.meti.render;

public class OpenElement implements Component {
    private final String tagName;

    public OpenElement(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String render() {
        return "<" + tagName + ">";
    }
}
