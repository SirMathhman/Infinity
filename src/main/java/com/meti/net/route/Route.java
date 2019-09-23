package com.meti.net.route;

import com.meti.net.Request;

public interface Route extends Processor {
    boolean canProcess(Request request);
}
