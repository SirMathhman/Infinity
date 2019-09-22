package com.meti;

class ClosingTag implements Component {
    private final String content;

    ClosingTag(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return "</" + content + ">";
    }
}
