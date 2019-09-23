package com.meti.render.script;

import com.meti.render.Component;

import java.util.function.Supplier;

interface Context extends Component {
    <T extends Ref<T>> T _(T ref);

    Context $(Component value);

    <A> Context $(Supplier<MonadStatement<A>> clazz, A input, Runnable action) throws ContextException;
}