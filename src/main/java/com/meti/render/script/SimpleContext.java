package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.Component;

import java.util.function.Supplier;

class SimpleContext implements Context {
    private final String content;
    private final Generator generator;
    private final Binding<Context> binding;

    SimpleContext(Binding<Context> binding) {
        this("", binding, new SimpleGenerator());
    }

    private SimpleContext(String content, Binding<Context> binding, Generator generator) {
        this.content = content;
        this.binding = binding;
        this.generator = generator;

        if (!binding.getOptionally().isPresent()) {
            binding.set(this);
        }
    }

    @Override
    public <T extends Ref<T>> T _(T ref) {
        String varName = generator.next();
        $(new Line("let " + varName + "=" + ref.render()));
        return ref.copy(varName);
    }

    @Override
    public Context $(Component value) {
        binding.map(context -> new SimpleContext(content + value.render(), binding, generator));
        return this;
    }

    @Override
    public <A> Context $(Supplier<MonadStatement<A>> supplier, A input, Runnable action) {
        Context context = supplier.get().with(input);
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
        Context context = binding.get();
        return this != context ? context.render() : "{" + content + "}";
    }
}
