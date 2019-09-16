package com.meti.render;

public class Tag implements Component {
    private final String content;

    public Tag(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return "<" + content + ">";
    }
}
