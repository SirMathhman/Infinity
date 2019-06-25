package com.meti;

import java.awt.image.BufferStrategy;

public interface Window {
    BufferStrategy getContext(int numBuffers);
}
