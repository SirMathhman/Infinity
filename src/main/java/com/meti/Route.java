package com.meti;

interface Route {
    default boolean canProcess(Context context) {
        return true;
    }

    Response process();
}
