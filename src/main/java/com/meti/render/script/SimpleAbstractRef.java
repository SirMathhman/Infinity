package com.meti.render.script;

abstract class SimpleAbstractRef<T extends Ref<T>> implements Ref<T> {
    final String content;

    SimpleAbstractRef(String content) {
        this.content = content;
    }

    public String render() {
        return content;
    }
}
