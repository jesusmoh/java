package com.jesusmoh;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SleeperWithExecutor {

    // Open new thread and run after time in timeUnit
    public void runWithDelay(Runnable runnable, long time, TimeUnit timeUnit) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(runnable, time, timeUnit);
        executorService.shutdown();
    }

}
