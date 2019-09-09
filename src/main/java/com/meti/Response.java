package com.meti;

public interface Response {
    String getContentType();

    byte[] getData();

    int getResponseCode();
}
