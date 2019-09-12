package com.meti.example;

public interface Document {
    Events events();

    ElementRef ref(Object header);
}
