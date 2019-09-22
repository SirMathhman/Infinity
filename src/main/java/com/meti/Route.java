package com.meti;

public interface Route {
    boolean canProcess(Request request);
    Response process();
}
