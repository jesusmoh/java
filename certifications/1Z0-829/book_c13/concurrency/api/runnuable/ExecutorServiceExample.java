package runnuable;

import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        var executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello from 1" + threadName);
        });
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello from 2" + threadName);
        });
        executor.shutdown();

        var executorpool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Runnable obj = new WorkerThread("e" + i * i);
            executorpool.execute(obj);
        }
        executorpool.shutdown();

        // var executor3 = Executors.newFixedThreadPool(1);

        // Callable<ComplexObject> callable = () -> {
        // try {
        // TimeUnit.SECONDS.sleep(2);
        // return new ComplexObject(1, "Example Object");
        // } catch (InterruptedException e) {
        // return null;
        // }
        // };

        // Future<ComplexObject> future = executor.submit(callable);

        // System.out.println("Submitted the task");

        // try {
        // ComplexObject result = future.get();
        // System.out.println("Result: " + result);
        // } catch (InterruptedException | ExecutionException e) {
        // e.printStackTrace();
        // }

    }
}
