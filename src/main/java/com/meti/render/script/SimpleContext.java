package com.meti.render.script;

import com.meti.render.Component;

class SimpleContext implements Context {
    private final String content;

    SimpleContext() {
        this("");
    }

    private SimpleContext(String content) {
        this.content = content;
    }

    @Override
    public Context print(Component value) {
        return new SimpleContext(content + value.render());
    }

    @Override
    public String render() {
        return content;
    }
}
