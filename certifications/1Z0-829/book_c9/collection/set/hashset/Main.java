package book_c9.collection.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(233);
        set.add(223);
        set.add(23);

        set.stream().forEach(x -> System.out.println(x));// only show 3. doesn't
    }

}
