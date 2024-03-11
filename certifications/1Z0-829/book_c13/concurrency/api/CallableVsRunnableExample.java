import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableVsRunnableExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Runnable example
        Runnable runnableTask = () -> {
            System.out.println("Executing a Runnable task.");
        };
        executor.execute(runnableTask);

        // Callable example
        Callable<Integer> callableTask = () -> {
            System.out.println("Executing a Callable task.");
            return 42;
        };
        Future<Integer> future = executor.submit(callableTask);

        try {
            int result = future.get();
            System.out.println("Result from Callable task: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}