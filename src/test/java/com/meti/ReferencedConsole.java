package com.meti;

import com.meti.render.Component;

class ReferencedConsole extends Referenced implements Console {
    @Override
    public Component log(Component reference) {
        return () -> getReference() + ".log(" + reference.render() + ");";
    }

    @Override
    protected String getReference() {
        return "console";
    }
}