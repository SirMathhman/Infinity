package com.meti;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ControllerLoader extends FXMLLoader {
    private final List<Object> injectableList = new ArrayList<>();

    public ControllerLoader(Object... injectableArray) {
        this.injectableList.addAll(Arrays.asList(injectableArray));
        setControllerFactory(new ControllerFactory());
    }

    public <T> T load(Source source, Object... injectableArray) throws IOException {
        return new ControllerLoader(injectableArray).load(source.getInputStream());
    }

    private class ControllerFactory implements Callback<Class<?>, Object> {
        @Override
        public Object call(Class<?> param) {
            try {
                Class[] classes = getClassArray(injectableList);
                return param.getDeclaredConstructor(classes)
                        .newInstance(injectableList);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public Class[] getClassArray(List<Object> objects) {
            return objects.stream()
                    .map((Function<Object, Class<?>>) Object::getClass)
                    .toArray(Class[]::new);
        }
    }
}