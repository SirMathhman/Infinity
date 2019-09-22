package com.meti.net.route;

public interface AssetRoute<T> extends Route {
    String buildWebPath(T other);
}
