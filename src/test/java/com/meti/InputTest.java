package com.meti;

import com.meti.render.node.InputBuilder;
import com.meti.render.node.InputType;
import com.meti.render.node.Node;
import com.meti.render.node.SimpleInputBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputTest {
    @Test
    void construct() {
        InputBuilder builder = new SimpleInputBuilder();
        Node node = builder.withID("anID")
                .withInputType(InputType.HIDDEN)
                .withInitialValue("some")
                .build();
        assertEquals("<input id=\"anID\" name=\"anID\" type=\"HIDDEN\" value=\"some\">", node.render().render());
    }

}
