package com.meti;

import com.meti.response.PlainTextResponse;
import com.meti.response.Response;
import com.meti.server.Context;
import com.meti.server.Route;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InlineRouteTest {
    @Test
    void construct() {
        Response expected = new PlainTextResponse("test");
        Predicate<Context> canProcess = context -> context.getPath().equals("/");
        Function<Context, Response> process = context -> expected;
        Route route = new InlineRoute(canProcess, process);
        Context context = () -> "/";
        assertTrue(route.canProcess(context));
        assertEquals(expected, route.process(context));
    }

    private static class InlineRoute implements Route {
        private final Predicate<Context> canProcess;
        private final Function<Context, Response> process;

        InlineRoute(Predicate<Context> canProcess, Function<Context, Response> process) {
            this.canProcess = canProcess;
            this.process = process;
        }

        @Override
        public boolean canProcess(Context context) {
            return canProcess.test(context);
        }

        @Override
        public Response process(Context context) {
            return process.apply(context);
        }
    }
}
