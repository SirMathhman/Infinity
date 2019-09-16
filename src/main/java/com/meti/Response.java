package com.meti;

public interface Response {
    ResponseCode getResponseCode();

    ResponseType getContentType();

    byte[] getBytes();
}
