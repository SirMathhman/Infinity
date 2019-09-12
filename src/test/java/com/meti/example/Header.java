package com.meti.example;

import com.meti.render.ClosedElement;
import com.meti.render.Component;
import com.meti.render.SimpleTag;

import java.util.Locale;

public class Header implements Node {
    private final HeaderSize size;
    private final String value;

    public Header(HeaderSize size, String value) {
        this.size = size;
        this.value = value;
    }

    @Override
    public Component render() {
        String lowerCaseSizeName = size.name().toLowerCase(Locale.ENGLISH);
        return new ClosedElement(new SimpleTag(lowerCaseSizeName), value);
    }
}
