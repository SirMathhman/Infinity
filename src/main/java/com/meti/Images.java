package com.meti;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;

final class Images {
    private Images() {
    }

    static int[] getPixels(BufferedImage source) {
        WritableRaster raster = source.getRaster();
        return getPixels(raster);
    }

     static int[] getPixels(WritableRaster raster) {
        DataBufferInt dataBuffer = (DataBufferInt) raster.getDataBuffer();
        return dataBuffer.getData();
    }
}
