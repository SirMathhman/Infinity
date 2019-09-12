package com.meti.example;

import com.meti.util.Binding;
import com.meti.util.SimpleBinding;

import java.net.MalformedURLException;

final class DraggableDivContent implements ContextProxy, NodeBuilder {
    private final Binding<Context> binding = new SimpleBinding<>();

    @Override
    public Node build() throws MalformedURLException {
        Node header = new Header(HeaderSize.H1, "Some Header");
        Document document = $(new DocumentType()).build();

        FunctionRef dragElement = $(StatementType.FUNCTION(1), params -> {
            ElementRef element = params[0].cast(SimpleElementRef::new);
            Vector2Type vectors = $(new Vector2TypeImpl());
            Vector2 old = vectors.empty();
            Vector2 delta = vectors.empty();

            FunctionRef closeDragElement = $(StatementType.FUNCTION(0), params13 -> {
                document.events().onMouseUp().clear();
                document.events().onMouseMove().clear();
            });

            FunctionRef elementDrag = $(StatementType.FUNCTION(1), params12 -> {
                EventRef event = params12[0].cast(SimpleEventRef::new);
                Vector2 coordinates = event.coordinates();
                delta.set(old.subtract(coordinates));
                old.set(coordinates);
                element.position().compute(previous -> previous.subtract(delta));
            });

            FunctionRef dragMouseDown = $(StatementType.FUNCTION(1), params1 -> {
                EventRef event = params1[0].cast(SimpleEventRef::new);
                $(event.preventDefault());
                old.set(event.coordinates());
                document.events().onMouseUp().set(closeDragElement);
                document.events().onMouseMove().set(elementDrag);
            });

            document.ref(header).events().onMouseDown().set(dragMouseDown);
        });

        Container content = new Divider();
        content.position().set(PositionType.ABSOLUTE);
        content.border().setAll(new Border(BorderType.SOLID, RGBColors.RED, new PixelConstraint(1)));
        content.addAll(header, new DraggableImage().build());

        $call(dragElement, document.ref(content));

        Constraint contentSize = new PixelConstraint(200);
        content.dimensions().set(contentSize, contentSize);

        return content;
    }

    @Override
    public Context context() {
        return binding.get();
    }
}
