package com.meti;

class PlainType implements ResponseType {
    @Override
    public String value() {
        return "type/plain";
    }
}
