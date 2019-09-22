package com.meti.render.element;

import com.meti.render.Component;

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
