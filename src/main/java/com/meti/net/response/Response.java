package com.meti.net.response;

public interface Response {
    ResponseCode getResponseCode();

    ResponseType getResponseType();

    byte[] getBytes();
}
