package com.jesusmoh;

import java.util.concurrent.TimeUnit;

public class ThreadSleepWithExecutor {

    public static SleeperWithExecutor sleeperWithExecutor;

    public ThreadSleepWithExecutor(){
        sleeperWithExecutor = new SleeperWithExecutor();
    }
    public void doTaskX(){

        System.out.println("Doing task X");
    }
    public void doTaskY(){

        System.out.println("Doing task Y");
    }
    public void doTaskZ(){

        System.out.println("Doing task Z");
    }

    public static void main(String[] args) {
        ThreadSleepWithExecutor threadSleepWithExecutor = new ThreadSleepWithExecutor();
        long sleepTime = 2000;
        System.out.println("Step 1 : Creating pool of no blokings threads");

        sleeperWithExecutor.runWithDelay(() -> threadSleepWithExecutor.doTaskX(), 2000, TimeUnit.MILLISECONDS);
        sleeperWithExecutor.runWithDelay(() -> threadSleepWithExecutor.doTaskY(), 3000, TimeUnit.MILLISECONDS);
        sleeperWithExecutor.runWithDelay(() -> threadSleepWithExecutor.doTaskZ(), 4000, TimeUnit.MILLISECONDS);


        //Thread.getAllStackTraces().keySet().forEach((t) -> System.out.println(t.getName()));
        System.out.println("Step 2 : Ending main app thread");
    }
}
