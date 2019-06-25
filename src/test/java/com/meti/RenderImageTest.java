package com.meti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

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

        int[] sourcePixels = ((DataBufferInt) source.getRaster().getDataBuffer()).getData();
        int[] destinationPixels = ((DataBufferInt) destination.getRaster().getDataBuffer()).getData();
        assertArrayEquals(sourcePixels, destinationPixels);
    }
}
