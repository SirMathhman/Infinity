package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SimpleContext implements Context {
    private final Binding<Context> binding;
    private final List<Component> components = new ArrayList<>();
    private final Generator generator;

    SimpleContext(Binding<Context> binding) {
        this(binding, new SimpleGenerator());
    }

    private SimpleContext(Binding<Context> binding, Generator generator) {
        this.binding = binding;
        this.generator = generator;
    }

    @Override
    public <T extends Ref<T>> T _(T ref) {
        String varName = generator.next();
        $(new Line("let " + varName + "=" + ref.render()));
        return ref.copy(varName);
    }

    @Override
    public Context $(Component value) {
        components.add(value);
        return this;
    }

    @Override
    public <A> Context $(MonadStatement<A> supplier, A input, Runnable action) {
        Context context = supplier.next(input, binding);
        render(action, context);
        return this;
    }


    private void render(Runnable action, Context context) {
        Context previous = binding.swap(context);
        action.run();
        binding.swap(previous);
        $(context);
    }

    @Override
    public String render() {
        String content = components.stream()
                .map(Component::render)
                .collect(Collectors.joining());
        return "{" + content + "}";
    }
}
