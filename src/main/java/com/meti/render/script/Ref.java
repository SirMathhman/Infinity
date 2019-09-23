package com.meti.render.script;

import com.meti.render.Component;

interface Ref<T extends Ref> extends Component {
    T copy(String content);
}
