package book_c8.deferredexecution.implicit;

import java.util.function.Supplier;

public class DeferredExecutionExample {
    public static void main(String[] args) {
        boolean condition = true; // This condition can be based on any logic

        Supplier<String> expensiveOperation = () -> {
            // Simulating a time-consuming operation
            try {
                Thread.sleep(3000); // Sleeping for 3 seconds to simulate the operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result of the expensive operation";
        };

        System.out.println("?");
        if (condition) {
            // The expensive operation will only be executed when the condition is true
            String result = expensiveOperation.get();

            System.out.println("Result: " + result);
        } else {
            System.out.println("The condition was not met, so the expensive operation was not executed");
        }
    }
}
