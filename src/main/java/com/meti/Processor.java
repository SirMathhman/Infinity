package com.meti;

interface Processor<I, O> {
    O process(I request);
}
