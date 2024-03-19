package c1_arrays_and_strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckPermutation {
    public static void main(String[] args) {
        var sentence = "hello";
        var sentence2 = "oleeh";
        System.out.println(checkPermutation(sentence, sentence2));
        System.out.println(checkPermutation2(sentence, sentence2));
    }

    // big O(n) funtional aproach 2.0
    // using a set to keep track of the chars in the string.
    // if the char is not in the set, then add it to the set.
    // if the char is in the set, then return false.
    // if the loop completes without returning false, then return true.
    // this approach is faster than the object approach, but it uses more memory.
    // the object approach uses less memory, but it is slower.
    // the object approach uses less memory, but it is slower.
    private static boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        var t = s1.chars().boxed().sorted().collect(Collectors.toList());
        return t.containsAll(s2.chars().boxed().sorted().collect(Collectors.toList()));
    }

    // big O(n) object aproach
    // using a set to keep track of the chars in the string.
    // if the char is not in the set, then add it to the set.
    // if the char is in the set, then return false.
    // if the loop completes without returning false, then return true.
    // this approach is faster than the functional approach, but it uses more
    // memory.
    // the functional approach uses less memory, but it is slower.
    // the functional approach uses less memory, but it is slower.
    private static boolean checkPermutation2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

}
