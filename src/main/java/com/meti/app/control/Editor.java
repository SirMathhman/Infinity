package com.meti.app.control;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 5/22/2019
 */
public interface Editor {
    boolean canShow(Class<?> clazz);
    String getName();
}