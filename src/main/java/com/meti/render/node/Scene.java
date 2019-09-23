package com.meti.render.node;

import com.meti.render.Component;
import com.meti.render.element.Attributes;
import com.meti.render.element.Group;
import com.meti.render.element.OpeningTag;
import com.meti.render.element.SimpleElementBuilder;

import java.nio.charset.Charset;
import java.util.Locale;

public class Scene implements Node {
    private final String title;
    private final Locale locale;
    private final Charset charSet;
    private final Node root;

    Scene(String title, Charset charSet, Locale locale, Node root) {
        this.charSet = charSet;
        this.locale = locale;
        this.title = title;
        this.root = root;
    }

    @Override
    public Component render() {
        Component docType = new OpeningTag("!DOCTYPE");
        Component html = buildHTML();
        return new Group(docType, html);
    }

    private Component buildHTML() {
        Component head = buildHead();
        Component body = buildBody();
        Component htmlAttributes = new Attributes("lang", locale.getLanguage());
        return new SimpleElementBuilder()
                .withAttributes(htmlAttributes)
                .withChildren(head, body)
                .withTagName("html")
                .build();
    }

    private Component buildBody() {
        return new SimpleElementBuilder()
                .withTagName("body")
                .withChildren(root.render())
                .build();
    }

    private Component buildHead() {
        Component charsetAttributes = new Attributes("charset", charSet.displayName());
        Component charSet = new OpeningTag("meta", charsetAttributes);
        Component title = buildTitle();
        return new SimpleElementBuilder()
                .withTagName("head")
                .withChildren(charSet, title)
                .build();
    }

    private Component buildTitle() {
        return new SimpleElementBuilder()
                .withTagName("title")
                .withChildren(() -> title)
                .build();
    }
}