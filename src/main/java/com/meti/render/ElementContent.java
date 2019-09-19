package com.meti.render;

public interface ElementContent extends Component {
    ElementContent append(String value);

    ElementContent append(Component value);
}
