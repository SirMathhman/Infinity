package com.meti.render.script;

class SimpleGenerator implements Generator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int value = -1;

    @Override
    public String next() {
        value++;
        char pre = ALPHABET.charAt(value % ALPHABET.length());
        return pre + String.valueOf(value);
    }
}
