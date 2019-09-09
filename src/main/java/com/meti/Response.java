package com.meti;

import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;

public interface Response {
    default NanoHTTPD.Response toNanoResponse() {
        ContentType contentType = getContentType();
        ResponseCode repsonseCode = getResponseCode();
        return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.valueOf(repsonseCode.name()), contentType.asString(),
                new ByteArrayInputStream(getData()), (long) getData().length);
    }

    ContentType getContentType();

    byte[] getData();

    ResponseCode getResponseCode();
}
