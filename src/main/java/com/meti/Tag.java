package com.meti;

class Tag implements Component {
    private final String content;

    Tag(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return "<" + content + ">";
    }
}
