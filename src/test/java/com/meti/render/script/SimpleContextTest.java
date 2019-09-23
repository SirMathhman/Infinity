package com.meti.render.script;

import com.meti.render.SimpleBinding;
import org.junit.jupiter.api.Test;

import static com.meti.render.script.SimpleStringRef.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleContextTest {

    @Test
    void print() {
        Console console = new SimpleConsole();
        Context context = new SimpleContext(new SimpleBinding<>())
                .$(console.log(of("Hello World!")));
        assertEquals("{console.log(\"Hello World!\");}", context.render());
    }
}