package book_c10.optional;

import java.util.Optional;

public class OptionalExample {
    public static Optional<String> findValue(boolean condition) {
        if (condition) {
            return Optional.of("Value is present");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Optional<String> result1 = findValue(true);
        result1.ifPresent(value -> System.out.println("Result 1: " + value));

        Optional<String> result2 = findValue(false);
        String output = result2.orElse("Value is absent");
        System.out.println("Result 2: " + output);

        try {
            String result3 = findValue(true).orElseThrow(() -> new RuntimeException("Value not found"));
            System.out.println("Result 3: " + result3);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
