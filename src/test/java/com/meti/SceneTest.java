package com.meti;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SceneTest {
    @Test
    void construct() {
        Component root = buildRoot();
        Component expected = buildExpected(root);
        Node node = buildActual(root);
        assertEquals(expected.render(), node.render().render());
    }

    private Component buildRoot() {
        return new SimpleElementBuilder()
                .withTagName("div")
                .build();
    }

    private Node buildActual(Component root) {
        SceneBuilder builder = new SimpleSceneBuilder();
        return builder.withTitle("A Title")
                .withCharSet(StandardCharsets.UTF_8)
                .withLocale(Locale.getDefault()).withRoot(root)
                .build();
    }

    private Component buildExpected(Component root) {
        Component docType = new OpeningTag("!DOCTYPE");
        Component charsetAttributes = new Attributes("charset", StandardCharsets.UTF_8.displayName());
        Component charSet = new OpeningTag("meta", charsetAttributes);
        Component component = () -> "A Title";
        Component title = new SimpleElementBuilder()
                .withTagName("title")
                .withChildren(component)
                .build();
        Component head = new SimpleElementBuilder()
                .withTagName("head")
                .withChildren(charSet, title)
                .build();
        Component body = new SimpleElementBuilder()
                .withTagName("body")
                .withChildren(root)
                .build();
        Component htmlAttributes = new Attributes("lang", Locale.getDefault().getLanguage());
        Component html = new SimpleElementBuilder()
                .withAttributes(htmlAttributes)
                .withChildren(head, body)
                .withTagName("html")
                .build();
        return new Group(docType, html);
    }
}
