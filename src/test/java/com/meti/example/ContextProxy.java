package com.meti.example;

import com.meti.render.Component;

public interface ContextProxy extends Context {
    @Override
    default <T extends Type> T $(T type) {
        return context().$(type);
    }

    @Override
    default FunctionRef $(StatementMetaData type, FunctionImpl function) {
        return context().$(type, function);
    }

    @Override
    default void $(Component component) {
        context().$(component);
    }

    @Override
    default void $call(FunctionRef dragElement, ElementRef content) {
        context().$call(dragElement, content);
    }

    Context context();
}
