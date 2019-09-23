package com.meti.render.script;

import com.meti.render.Component;

interface Context extends Component {
    <T extends Ref<T>> T _(T ref);

    Context $(Component value);

    <A> Context $(MonadStatement<A> statement, A input, Runnable action);
}