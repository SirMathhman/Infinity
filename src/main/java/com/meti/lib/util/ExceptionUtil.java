package com.meti.lib.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/4/2019
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static Exception compound(Collection<Exception> exceptions) throws Exception {
        return compound(exceptions, "\n\t");
    }

    public static Exception compound(Collection<Exception> exceptions, String delimiter) throws Exception {
        return new Exception(exceptions
                .stream()
                .map(ExceptionUtil::writeException)
                .collect(Collectors.joining(delimiter))
        );
    }

    public static String writeException(Exception e) {
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }
}
