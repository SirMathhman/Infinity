package com.meti.example;

import com.meti.render.scene.Node;

import java.net.MalformedURLException;

public interface NodeBuilder {
    Node build() throws MalformedURLException;
}
