package book_c9.imutuablesFactories;

import java.util.Arrays;
import java.util.Set; // Import Arrays for Arrays.toString()

public class SetFactory {
    public static void main(String[] args) {

        Set<Integer> setl = Set.of(0, 1, 2);

        System.out.println(Arrays.toString(setl.toArray()));
    }
}
