package com.meti.server.response;

public interface Response {
    byte[] getData();

    ResponseCode getResponseCode();

    String getType();
}
