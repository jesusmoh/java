package c1_arrays_and_strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Case2Permutation {
    public static void main(String[] args) {

        var sentence = "hello";
        var sentence2 = "oleeh";
        System.out.println(whoIsPermutation(sentence, sentence2));
    }

    // funtional aproach
    static boolean whoIsPermutation(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;

        List<Integer> r1 = s1.chars().sorted().boxed().collect(Collectors.toList());
        List<Integer> r2 = s2.chars().sorted().boxed().collect(Collectors.toList());

        return r2.equals(r1);
    }

    // object aproach
    static boolean whoIsPermutation2(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

}
