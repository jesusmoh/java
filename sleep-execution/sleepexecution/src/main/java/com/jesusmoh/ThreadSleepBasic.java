package com.jesusmoh;

public class ThreadSleepBasic {

    private static SleeperBasic sleeperBasic;

    public ThreadSleepBasic() {
        sleeperBasic = new SleeperBasic();
    }

    public void doTaskX(){
        System.out.println("Doing task X");
    }

    public static void main(String[] args) {
      long time = 2000;
      ThreadSleepBasic threadSleepBasic = new ThreadSleepBasic();
      System.out.println("Step 1");
      sleeperBasic.runWithDelay(()->threadSleepBasic.doTaskX(), time);
      Thread.getAllStackTraces().keySet().forEach((t) -> System.out.println(t.getId() + "- " + t.getName()));
      System.out.println("Step 2");
    }
}
