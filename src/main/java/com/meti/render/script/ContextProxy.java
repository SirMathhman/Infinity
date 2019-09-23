package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.Component;

import java.util.function.Supplier;

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
    default <A> Context $(Supplier<MonadStatement<A>> clazz, A input, Runnable action) throws ContextException {
        return get().$(clazz, input, action);
    }

    @Override
    default String render() {
        return get().render();
    }
}
