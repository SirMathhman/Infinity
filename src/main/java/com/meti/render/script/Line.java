package com.meti.render.script;

import com.meti.render.Component;

class Line implements Component {
    private final String content;

    Line(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return content + ";";
    }
}
