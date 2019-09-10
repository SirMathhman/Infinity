package com.meti;

import com.meti.route.Route;
import fi.iki.elonen.NanoHTTPD;

import static fi.iki.elonen.NanoHTTPD.MIME_HTML;
import static fi.iki.elonen.NanoHTTPD.Response.Status.OK;
import static fi.iki.elonen.NanoHTTPD.newFixedLengthResponse;

final class TypeTestRoute implements Route<NanoHTTPD.Response> {
    @Override
    public NanoHTTPD.Response process() {
        return newFixedLengthResponse(OK, MIME_HTML, "<!DOCTYPE html><html></html>");
    }
}
