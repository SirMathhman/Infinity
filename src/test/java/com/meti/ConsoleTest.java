package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleTest {
    private final Console console = new ReferencedConsole();

    @Test
    void print() {
        Block block = new Block();
        block.write(console.log(StringRef.of("Hello World!")));
        String actual = block.render();
        assertEquals("console.log(\"Hello World!\");", actual);
    }
}
