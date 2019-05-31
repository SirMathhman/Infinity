package com.meti.lib.net.server;

import java.time.Duration;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 5/30/2019
 */
public interface Terminator {
    void terminate(Duration duration) throws InterruptedException;
}