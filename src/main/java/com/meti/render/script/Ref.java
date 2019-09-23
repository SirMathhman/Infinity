package com.meti.render.script;

import com.meti.render.Component;

interface Ref<T extends Ref> extends Component {
    default BoolRef $(Conditional conditional, T other) {
        return new SimpleBoolRef(render() + conditional.getValue() + other.render());
    }

    T copy(String content);
}
