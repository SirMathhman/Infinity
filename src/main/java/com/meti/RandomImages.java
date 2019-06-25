package com.meti;

import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

final class RandomImages {
    private static final int MAX_COLOR_COMPONENT = 255;
    private static final int COMPONENT_LENGTH = 0xFF;
    private static final int COMPONENTS_COUNT = 4;

    private RandomImages() {
    }

    private static void fillData(int[] data) {
        Random random = new SecureRandom();
        IntStream.range(0, data.length)
                .forEach(value -> fillDataRandomly(data, value, random));
    }

    private static void fillDataRandomly(int[] data, int index, Random random) {
        int red = random.nextInt(MAX_COLOR_COMPONENT + 1);
        int green = random.nextInt(MAX_COLOR_COMPONENT + 1);
        int blue = random.nextInt(MAX_COLOR_COMPONENT + 1);
        int value = toInt(MAX_COLOR_COMPONENT, red, green, blue);
        data[index] = value;
    }

    private static int toInt(int alpha, int red, int green, int blue) {
        List<Integer> componentsList = List.of(alpha, red, green, blue);
        int sum = 0;
        int size = componentsList.size();
        for (int i = 0; i < size; i++) {
            sum |= getShift(componentsList.get(i), getAmountToBitshift(i));
        }
        return sum;
    }

    private static int getAmountToBitshift(Integer integer) {
        return 8 * (COMPONENTS_COUNT - 1 - integer);
    }

    private static int getShift(int value, int amount) {
        return (value & COMPONENT_LENGTH) << amount;
    }

    static BufferedImage createRandomIntImage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        fillData(Images.getPixels(image));
        return image;
    }
}
