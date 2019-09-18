package com.meti;

import com.meti.render.Component;

class StringRef implements Component {
    private final String value;

    private StringRef(String value) {
        this.value = value;
    }

    static Component of(String value) {
        return new StringRef(value);
    }

    @Override
    public String render() {
        return "\"" + value + "\"";
    }
}
