package com.meti.example;

import com.meti.render.Component;

interface Context {
    <T extends Type> T $(T type);

    FunctionRef $(StatementMetaData type, FunctionImpl function);

    void $(Component component);

    void $call(FunctionRef dragElement, ElementRef content);
}
