package com.meti;

import com.meti.render.ClosedElement;
import com.meti.render.Component;
import com.meti.render.OpenElement;
import com.meti.render.SimpleTag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HTMLTest {
    @Test
    void construct() {
        Component title = new ClosedElement(new SimpleTag("title"), "Title");
        Component header = new ClosedElement(new SimpleTag("h1"), "Header");
        Component head = new ClosedElement(new SimpleTag("head"), title.render());
        Component body = new ClosedElement(new SimpleTag("body"), header.render());
        Component docType = new OpenElement("!DOCTYPE html");
        Component html = ClosedElement.compose(new SimpleTag("html"), head, body);
        Component element = Component.compose(docType, html);
        String actual = element.render();
        Assertions.assertEquals("<!DOCTYPE html><html>" +
                "<head><title>Title</title></head>" +
                "<body><h1>Header</h1></body>" +
                "</html>", actual);
    }
}
