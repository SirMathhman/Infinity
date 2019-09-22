package com.meti;

import com.meti.net.Request;
import com.meti.net.response.Response;
import com.meti.net.route.PathRoute;
import com.meti.net.route.RouteMethod;
import com.meti.render.node.Form;
import com.meti.render.node.Node;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FormTest {
    @Test
    void construct() {
        Node submit = new Submit();
        Node form = new Form(new SubmitRoute(), RouteMethod.POST, Collections.singleton(submit));
        assertEquals("<form action=\"/submit\" method=\"POST\"><input type=\"submit\"></form>", form.render().render());
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
