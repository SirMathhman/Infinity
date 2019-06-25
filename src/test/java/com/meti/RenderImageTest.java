package com.meti;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class RenderImageTest {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    @Test
    void render() {
        BufferedImage source = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        BufferedImage destination = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = destination.getGraphics();
        Context context = new GraphicsContext(graphics);
        context.render(source);

        int[] sourcePixels = Images.getPixels(source);
        int[] destinationPixels = Images.getPixels(destination);
        assertArrayEquals(sourcePixels, destinationPixels);
    }
}
