package com.meti;

import com.meti.render.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InlineScriptTest {

    @Test
    void render() {
        Node script = new InlineScript("console.log(\"Hello World!\");");
        assertEquals("<script>console.log(\"Hello World!\");</script>", script.render().render());
    }
}