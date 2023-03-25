package com.jesusmoh;

public class SleeperBasic {

    // Stop current thread "time", and after run
    public void runWithDelay(Runnable runnable,  long time) {
        try {
            Thread.sleep(time);
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }
}
