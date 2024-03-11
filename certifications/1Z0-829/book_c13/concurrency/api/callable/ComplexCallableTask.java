
import java.util.concurrent.Callable;

public class ComplexCallableTask implements Callable<Long> {

    private final long number;

    public ComplexCallableTask(long number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        System.out.println("Calculating factorial for: " + number);
        return calculateFactorial(number);
    }

    private long calculateFactorial(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}