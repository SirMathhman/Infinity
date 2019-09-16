package com.meti.render;

interface ElementContent extends Component {
    ElementContent append(String value);

    ElementContent append(Component value);
}
