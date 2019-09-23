package com.meti.render.script;

import com.meti.render.Component;

public class SimpleConsole implements Console {
    @Override
    public Component log(Ref<?> ref) {
        return new Line("console.log(" + ref.render() + ")");
    }
}