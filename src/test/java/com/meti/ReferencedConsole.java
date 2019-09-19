package com.meti;

import com.meti.render.Component;

class ReferencedConsole implements Console {
    @Override
    public Component log(Component reference) {
        return () -> "console.log(" + reference.render() + ");";
    }
}