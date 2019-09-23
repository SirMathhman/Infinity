package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.Component;
import com.meti.render.SimpleBinding;

class SimpleContext implements Context {
    private final String content;
    private final Binding<Context> binding = new SimpleBinding<>(this);

    SimpleContext() {
        this("");
    }

    private SimpleContext(String content) {
        this.content = content;
    }

    @Override
    public Context $(Component value) {
        binding.map(context -> new SimpleContext(content + value.render()));
        return this;
    }

    @Override
    public String render() {
        Context context = binding.get();
        return this != context ? context.render() : content;
    }
}
