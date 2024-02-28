package book_c10.streams;

import java.util.Arrays;
import java.util.List;

public class StreamPipeline {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "example");

        long count = words.stream()
                .filter(word -> word.length() > 4) // Intermediate Operation: Filter
                .map(String::toUpperCase) // Intermediate Operation: Map
                .sorted() // Intermediate Operation: Sort
                .distinct() // Intermediate Operation: Distinct
                .peek(System.out::println) // Intermediate Operation: Peek
                .skip(2) // Intermediate Operation: Skip
                .limit(3) // Intermediate Operation: Limit
                .count(); // Terminal Operation: Count

        System.out.println("Total count after stream operations: " + count);
    }
}
