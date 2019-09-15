package com.meti;

public interface Response {
    ResponseCode getResponseCode();

    ContentType getContentType();

    byte[] getBytes();
}
