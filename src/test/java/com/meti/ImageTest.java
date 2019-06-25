package com.meti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ImageTest {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private final BufferedImage sourceImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final BufferedImage destinationImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private final int[] data = new int[WIDTH * HEIGHT];

    @BeforeEach
    void before() {
        fillData(data);
        copyData();
    }

    private void copyData() {
        int[] sourceData = getImageData(sourceImage);
        System.arraycopy(this.data, 0, sourceData, 0, this.data.length);
    }

    private static void fillData(int[] data) {
        Random random = new SecureRandom();
        IntStream.range(0, data.length)
                .forEach(value -> fillDataRandomly(data, value, random));
    }

    private static void fillDataRandomly(int[] data, int index, Random random) {
        data[index] = random.nextInt(2);
    }

    private static int[] getImageData(BufferedImage image) {
        WritableRaster imageRaster = image.getRaster();
        DataBufferInt dataBuffer = (DataBufferInt) imageRaster.getDataBuffer();
        return dataBuffer.getData();
    }

    @Test
    void validateData() {
        Graphics2D graphics = destinationImage.createGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        int[] destinationData = getImageData(destinationImage);
        assertArrayEquals(data, destinationData);
    }
}
