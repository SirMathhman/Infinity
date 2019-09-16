package com.meti;

import com.meti.render.Component;
import com.meti.render.Element;
import com.meti.render.Group;
import com.meti.render.Tag;
import com.meti.response.Response;
import com.meti.response.ResponseCodes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HTMLResponseTest {
    @Test
    void render() {
        List<Component> list = new ArrayList<>();
        list.add(new Tag("!DOCTYPE html"));
        list.add(new Element("html"));
        Response response = new HTMLResponse(ResponseCodes.OK, new Group(list));
        assertEquals("<!DOCTYPE html><html></html>", new String(response.getBytes()));
    }
}