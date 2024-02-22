package book_c8.lambdaexpresions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DummyLambdas {
    public static void main(String[] args) {

        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> list = Arrays.asList("merenge", "jesus", "manuel", "manuel", "ortiz", "hidalgo", "moriano");

        // filter
        Stream s = list.stream().filter((String x) -> {
            return x.startsWith("m");
        });

        // order and limit
        Stream f = s.sorted().limit(1);

        Stream k = f.distinct();

        Stream z = k.map(x -> String.valueOf(x).concat("*"));

        System.out.println("Check the list " + list.size());

        z.forEach(x -> System.out.println(x));

        System.out.println("Check the list " + list.size());
    }
}
