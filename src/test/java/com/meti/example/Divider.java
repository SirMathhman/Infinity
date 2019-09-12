package com.meti.example;

import com.meti.render.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

class Divider implements Container {
    private final Borders borders = new SimpleBorders();
    private final Collection<Node> children = new ArrayList<>();
    private final Dimensions dimensions = new SimpleDimensions();
    private final Binding<PositionType> position = new SimpleBinding<>();

    @Override
    public void addAll(Node... nodes) {
        children.addAll(Arrays.asList(nodes));
    }

    @Override
    public Borders border() {
        return borders;
    }

    @Override
    public Dimensions dimensions() {
        return dimensions;
    }

    @Override
    public Binding<PositionType> position() {
        return position;
    }

    @Override
    public Component render() {
        Attributes attributes = new MapAttributes();

        Styles styles = new Styles();
        borders.build().forEach(styles::put);
        styles.put("width", dimensions.width().get().render());
        styles.put("height", dimensions.height().get().render());
        styles.put("position", position.get().name().toLowerCase(Locale.ENGLISH));
        attributes.put("style", styles);
        return new ClosedElement(new AttributeTag("div", attributes), Component.compose(children
                .stream().map(Node::render)));
    }
}
