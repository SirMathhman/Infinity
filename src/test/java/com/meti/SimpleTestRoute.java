package com.meti;

import com.meti.route.Route;
import fi.iki.elonen.NanoHTTPD;

final class SimpleTestRoute implements Route<NanoHTTPD.Response> {
    @Override
    public NanoHTTPD.Response process() {
        return NanoHTTPD.newFixedLengthResponse("test");
    }
}
