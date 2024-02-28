import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class PrimitiveStreams {

    public static void main(String[] args) {
        int[] numbers = { 4, 7, 2, 9, 5 };

        // Creating an IntStream from an array
        IntStream intStream = IntStream.of(numbers);

        // Common operations on primitive streams
        int sum = intStream.sum(); // Calculating the sum
        System.out.println("Sum of numbers: " + sum);

        IntSummaryStatistics stats = IntStream.of(numbers).summaryStatistics();
        System.out.println("Statistics: " + stats);

        // Filtering and printing even numbers
        System.out.print("Even numbers: ");
        IntStream.of(numbers)
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.print(num + " "));

        // Mapping and reducing to find the maximum
        int max = IntStream.of(numbers)
                .map(x -> x * x)
                .reduce(Integer::max)
                .orElse(0);
        System.out.println("Maximum after squaring: " + max);
    }
}
