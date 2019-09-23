package com.meti.render.script;

import com.meti.render.Component;
import org.junit.jupiter.api.Test;

import static com.meti.render.script.SimpleStringRef.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleConsoleTest {

    @Test
    void log() {
        Console console = new SimpleConsole();
        Component log = console.log(of("test"));
        assertEquals("console.log(\"test\");", log.render());
    }
}