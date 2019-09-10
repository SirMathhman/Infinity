package com.meti;

public interface Response {
    byte[] getData();

    ResponseCode getResponseCode();

    String getType();
}
