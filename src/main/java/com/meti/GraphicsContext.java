package com.meti;

import java.awt.*;

public class GraphicsContext implements Context {
    protected final Graphics graphics;

    public GraphicsContext(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void render(Image image) {
        this.graphics.drawImage(image, 0, 0, null);
    }
}
