package com.meti;

import com.meti.render.ClosedElement;
import com.meti.render.Component;
import com.meti.render.OpenElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HTMLTest {
    @Test
    void construct() {
        Component title = new ClosedElement("title", "Title");
        Component header = new ClosedElement("h1", "Header");
        Component head = new ClosedElement("head", title.render());
        Component body = new ClosedElement("body", header.render());
        Component docType = new OpenElement("!DOCTYPE html");
        Component html = ClosedElement.group("html", head, body);
        Component element = Component.compose(docType, html);
        String actual = element.render();
        Assertions.assertEquals("<!DOCTYPE html><html>" +
                "<head><title>Title</title></head>" +
                "<body><h1>Header</h1></body>" +
                "</html>", actual);
    }
}
