package com.meti.app.control;

import com.meti.app.ExecutorServiceManager;
import com.meti.app.core.runtime.InfinityState;
import com.meti.lib.State;
import com.meti.lib.fx.StageManager;
import com.meti.lib.fx.StateController;
import com.meti.lib.log.Console;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 4/23/2019
 */
public class InfinityController extends StateController {
    final InfinityState state;

    ExecutorServiceManager executorServiceManager;
    private StageManager stageManager;
    Console console;

    public InfinityController(State state) {
        super(state);

        if (state instanceof InfinityState) {
            this.state = buildFields((InfinityState) state);
        } else {
            throw new IllegalArgumentException(InfinityState.class.getSimpleName() + " is not assignable to " + state.getClass());
        }
    }

    public InfinityState buildFields(InfinityState state) {
        executorServiceManager = state.getExecutorServiceManager();
        console = state.getConsole();
        stageManager = state.getStageManager();
        return state;
    }
}
