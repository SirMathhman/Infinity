package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.SimpleBinding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.meti.render.script.Conditionals.STRICT;
import static com.meti.render.script.SimpleStringRef.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IfTest implements ContextProxy {
    private Binding<Context> binding;
    private SimpleContext context;

    @BeforeEach
    void setUp() {
        binding = new SimpleBinding<>();
        context = new SimpleContext(binding);
    }

    @Test
    void renderIf() throws ContextException {
        Console console = new SimpleConsole();
        StringRef var0 = _(of("5"));
        StringRef var1 = _(of("5"));
        $(If.class, var0.$(STRICT, var1), () ->
                $(console.log(of("2"))));
        assertEquals("{let a0=\"5\";let b1=\"5\";if(a0===b1){console.log(\"2\");}}", render());
    }

    @Override
    public Binding<Context> getBinding() {
        return binding;
    }
}