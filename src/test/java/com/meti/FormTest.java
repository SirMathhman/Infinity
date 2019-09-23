package com.meti;

import com.meti.net.Method;
import com.meti.net.Request;
import com.meti.net.response.Response;
import com.meti.net.route.PathRoute;
import com.meti.render.node.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FormTest {
    @Test
    void construct() {
        Node submit = new Submit();
        Node form = buildForm(submit);
        assertEquals("<form action=\"/submit\" method=\"POST\"><input type=\"submit\"></form>", form.render().render());
    }

    private Form buildForm(Node submit) {
        return new FormBuilder()
                .withNodeData(buildData())
                .withAction(new SubmitRoute())
                .withMethod(Method.POST)
                .withChildren(Collections.singleton(submit))
                .build();
    }

    private NodeData buildData() {
        NodeDataBuilder builder = new SimpleNodeDataBuilder();
        return builder.build();
    }

    private static class SubmitRoute implements PathRoute {
        @Override
        public String getPath() {
            return "/submit";
        }

        @Override
        public Response process(Request request) {
            fail();
            return null;
        }
    }
}
