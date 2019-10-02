package com.meti;

interface Response {
    ResponseCode code();

    ResponseType type();

    byte[] data();
}
