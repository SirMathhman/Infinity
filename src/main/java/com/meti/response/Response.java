package com.meti.response;

public interface Response {
    String getResponseType();

    byte[] getData();

    int getResponseCode();
}
