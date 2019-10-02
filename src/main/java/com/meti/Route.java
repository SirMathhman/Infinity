package com.meti;

interface Route<I, O> extends Processor<I, O> {
    boolean canProcess(I input);
}
