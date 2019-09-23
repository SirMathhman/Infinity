package com.meti.render.script;

import com.meti.render.Binding;

class If extends SimpleContext {
    private final BoolRef condition;

    If(BoolRef condition, Binding<Context> binding) {
        super(binding);
        this.condition = condition;
    }

    @Override
    public String render() {
        return "if(" + condition.render() + ")" + super.render();
    }
}
