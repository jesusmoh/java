package book_c9.imutuablesFactories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFactory {
    public static void main(String[] args) {

        // Mutuable
        ArrayList<String> t = new ArrayList<String>(); // change size and values
        List<String> a = Arrays.asList("a", "b", "c"); // change values

        t.add("?");
        a.set(0, "x");
        a.stream().forEach(e -> System.out.println(e));
        a.replaceAll(x -> {
            return (x.endsWith("b")) ? "BB" : "-BB";
        });
        a.stream().forEach(e -> System.out.println(e));

        // Inmutuables Factories
        List<String> b = List.of("a", "b", "c");
        List<String> c = List.copyOf(t);

        // b.set(0, "x"); don't compile
        // c.add("p"); don't compile
    }
}
