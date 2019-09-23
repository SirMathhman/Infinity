package com.meti.render.script;

class SimpleStringRef extends SimpleAbstractRef<StringRef> implements StringRef {

    SimpleStringRef(String content) {
        super(content);
    }

    static StringRef of(String content) {
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

}
