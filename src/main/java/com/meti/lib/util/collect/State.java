package com.meti.lib.util.collect;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/22/2019
 */
public class State extends ArrayList<Object> {
    private <T> Stream<T> byClass(Class<T> tClass) {
        return byPredicate(new TypePredicate<>(tClass))
                .map(new TypeFunction<>(tClass));
    }

    private Stream<Object> byPredicate(Predicate<Object> predicate) {
        return stream().filter(predicate);
    }

    protected <T> T byClassToSingle(Class<T> tClass) {
        return byClass(tClass).findAny().orElseThrow();
    }
}