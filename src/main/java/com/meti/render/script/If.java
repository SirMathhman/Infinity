package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.SimpleBinding;

class If extends SimpleContext implements MonadStatement<BoolRef> {
    private final BoolRef condition;

    public If() {
        this(null, new SimpleBinding<>());
    }

    private If(BoolRef condition, Binding<Context> binding) {
        super(binding);
        this.condition = condition;
    }

    @Override
    public MonadStatement<BoolRef> with(BoolRef argument) {
        return new If(argument, new SimpleBinding<>());
    }

    @Override
    public String render() {
        return "if(" + condition.render() + ")" + super.render();
    }
}
