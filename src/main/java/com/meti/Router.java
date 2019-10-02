package com.meti;

import java.util.Collection;

interface Router<I, O, R extends Route<I, O>> extends Processor<I, O> {
    O route(I input);

    Collection<? extends R> routes();
}
