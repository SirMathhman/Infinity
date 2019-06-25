package com.meti;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.meti.Images.getPixels;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ImageTest {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private final BufferedImage sourceImage = RandomImages.createRandomIntImage(WIDTH, HEIGHT);
    private final BufferedImage destinationImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    @Test
    void validateData() {
        Graphics2D graphics = destinationImage.createGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        assertArrayEquals(getPixels(sourceImage), getPixels(destinationImage));
    }
}
