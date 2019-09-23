package com.meti.render.script;

class SimpleBoolRef extends SimpleAbstractRef<BoolRef> implements BoolRef {
    SimpleBoolRef(String content) {
        super(content);
    }

    @Override
    public BoolRef copy(String content) {
        return new SimpleBoolRef(content);
    }
}
