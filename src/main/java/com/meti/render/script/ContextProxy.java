package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.Component;

interface ContextProxy extends Context {
    Binding<Context> getBinding();

    @Override
    default <T extends Ref<T>> T _(T ref) {
        return get()._(ref);
    }

    default Context get() {
        return getBinding().get();
    }

    @Override
    default Context $(Component value) {
        return get().$(value);
    }

    @Override
    default <A> Context $(MonadStatement<A> statement, A input, Runnable action) {
        return get().$(statement, input, action);
    }

    @Override
    default String render() {
        return get().render();
    }
}
