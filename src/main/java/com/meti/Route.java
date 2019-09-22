package com.meti;

interface Route {
    boolean canProcess(Request request);
    Response process();
}
