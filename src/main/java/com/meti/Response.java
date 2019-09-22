package com.meti;

public interface Response {
    ResponseCode getResponseCode();

    ResponseType getResponseType();

    byte[] getBytes();
}
