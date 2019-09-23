package com.meti.render.script;

import org.junit.jupiter.api.Test;

import static com.meti.render.script.SimpleStringRef.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleContextTest {

    @Test
    void print() {
        Console console = new SimpleConsole();
        Context context = new SimpleContext()
                .print(console.log($("Hello World!")));
        assertEquals("console.log(\"Hello World!\");", context.render());
    }
}