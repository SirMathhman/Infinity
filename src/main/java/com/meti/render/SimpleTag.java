package com.meti.render;

public class SimpleTag implements Tag {
    private final String tagName;

    public SimpleTag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String renderClosing() {
        return "</" + tagName + ">";
    }

    @Override
    public String renderOpening() {
        return "<" + tagName + ">";
    }
}
