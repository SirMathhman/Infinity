package com.meti;

interface Response {
    ResponseCode getResponseCode();

    ResponseType getResponseType();

    byte[] getBytes();
}
