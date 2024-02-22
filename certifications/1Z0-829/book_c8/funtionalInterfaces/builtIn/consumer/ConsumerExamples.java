package book_c8.funtionalInterfaces.builtIn.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExamples {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Consumer<List<String>> consumer = (list) -> {
            System.out.println("Names:");
            for (String name : list) {
                System.out.println("- " + name);
            }
        };

        consumer.accept(names);
    }
}
