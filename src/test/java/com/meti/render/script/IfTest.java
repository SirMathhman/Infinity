package com.meti.render.script;

import com.meti.render.Binding;
import com.meti.render.SimpleBinding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.meti.render.script.Conditionals.STRICT;
import static com.meti.render.script.MonadStatements.IF;
import static com.meti.render.script.SimpleStringRef.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IfTest implements ContextProxy {
    private Binding<Context> binding;

    @BeforeEach
    void setUp() {
        binding = new SimpleBinding<>();
        binding.set(new SimpleContext(binding));
    }

    @Test
    void renderIf() {
        Console console = new SimpleConsole();
        StringRef var0 = _(of("5"));
        StringRef var1 = _(of("5"));
        $(IF, var0.$(STRICT, var1), () ->
                $(console.log(of("2"))));
        assertEquals("{let a0=\"5\";let b1=\"5\";if(a0===b1){console.log(\"2\");}}", render());
    }

    @Test
    void renderNestedIf() {
        Console console = new SimpleConsole();
        StringRef a0 = _(of("5"));
        StringRef b1 = _(of("5"));
        $(IF, a0.$(STRICT, b1), () ->
                $(IF, b1.$(STRICT, a0), () ->
                        $(console.log(of("2")))));
        assertEquals("{let a0=\"5\";let b1=\"5\";if(a0===b1){if(b1===a0){console.log(\"2\");}}}", render());
    }

    @Override
    public Binding<Context> getBinding() {
        return binding;
    }
}