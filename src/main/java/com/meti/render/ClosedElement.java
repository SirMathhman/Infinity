package com.meti.render;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ClosedElement implements Component {
    private final Component content;
    private final String tagName;

    public ClosedElement(String tagName, String content) {
        this(tagName, () -> content);
    }

    private ClosedElement(String tagName, Component content) {
        this.tagName = tagName;
        this.content = content;
    }

    public static Component group(String tagName, Component... content) {
        return new ClosedElement(tagName, () -> Arrays.stream(content)
                .map(Component::render)
                .collect(Collectors.joining()));
    }

    @Override
    public String render() {
        return "<" + tagName + ">" + content.render() + "</" + tagName + ">";
    }
}
