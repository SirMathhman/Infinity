package com.meti.lib.net.client;

import com.meti.lib.net.ComplexCloseable;
import com.meti.lib.net.handle.ResponseHandler;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 5/30/2019
 */
public interface Client extends ComplexCloseable, ResponseProcessor {
    String getName();

    default void writeAndFlush(Serializable message) throws IOException {
        write(message);
        flush();
    }

    void writeAndFlushIterable(Iterable<? extends Serializable> collection) throws IOException;

    void write(Serializable serializable) throws IOException;

    void flush() throws IOException;
}