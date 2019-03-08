package com.meti.lib;

import com.meti.lib.util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 2/24/2019
 */
public class State {
    private final List<Object> list = new ArrayList<>();

    public void add(Object obj) {
    }

    public <T> Optional<T> byClassToSingle(Class<T> tClass) throws Exception {
        List<T> list = byClass(tClass);
        return CollectionUtil.toSingle(list);
    }

    public <T> List<T> byClass(Class<T> tClass) throws Exception {
        TryableFactory factory = new TryableFactory();
        return factory.checkAll(list.stream()
                .filter(o -> tClass.isAssignableFrom(o.getClass()))
                .map(factory.apply(tClass::cast))
                .flatMap(OptionalUtil::stream)
                .collect(Collectors.toList()));
    }

    public State createSubState() {
        State state = new State();
        list.add(state);
        return state;
    }

    public Stream<Object> stream() {
        return Stream.empty();
    }
}