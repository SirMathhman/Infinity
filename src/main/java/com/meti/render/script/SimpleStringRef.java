package com.meti.render.script;

class SimpleStringRef implements StringRef {
    private final String content;

    SimpleStringRef(String content) {
        this.content = content;
    }

    static StringRef $(String content) {
        return new SimpleStringRef("\"" + content + "\"");
    }

    @Override
    public StringRef concat(StringRef other) {
        return new SimpleStringRef(content + "+" + other.render());
    }

    @Override
    public StringRef copy(String content) {
        return new SimpleStringRef(content);
    }

    @Override
    public String render() {
        return content;
    }
}
