package book_c8.deferredexecution.implicit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AnotheExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> stream = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2);

        // At this point, no processing has been done on the stream

        // Method Reference: Uses the :: operator to separate the class or object from
        // the method name (e.g., System.out::println).
        // Lambda Expression: Uses the -> operator to separate the parameters from the
        // body of the lambda (e.g., x -> System.out.println(x)).

        stream.forEach(System.out::println); // Processing is done here

        // stream.forEach(x -> System.out.println(x));

        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.forEach(System.out::println); // Method reference
        // This is equivalent to:
        list.forEach(x -> System.out.println(x)); // Lambda expression

    }

}
