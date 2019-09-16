package com.meti.response;

public interface Response {
    ResponseCode getResponseCode();

    ResponseType getContentType();

    byte[] getBytes();
}
