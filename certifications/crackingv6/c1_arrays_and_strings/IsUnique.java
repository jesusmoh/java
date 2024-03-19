package c1_arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
    public static void main(String[] args) {
        var s = "murcielago";
        System.out.println(isUnique(s));
        System.out.println(isUnique2(s));
        System.out.println(isUnique3(s));

    }

    // big O(n) funtional aproach 2.0
    // using a set to keep track of the chars in the string.
    // if the char is not in the set, then add it to the set.
    // if the char is in the set, then return false.
    // if the loop completes without returning false, then return true.
    // this approach is faster than the object approach, but it uses more
    // memory.
    // the object approach uses less memory, but it is slower.
    // the object approach uses less memory, but it is slower.
    private static boolean isUnique(String s) {
        if (s == null || s.length() == 0)
            return false;
        return s.chars().distinct().count() != s.length() ? false : true;
    }

    // big O(n) object aproach 2.0
    // using a set to keep track of the chars in the string.
    // if the char is not in the set, then add it to the set.
    // if the char is in the set, then return false.
    // if the loop completes without returning false, then return true.
    // this approach is faster than the functional approach, but it uses more
    // memory.
    // the functional approach uses less memory, but it is slower.
    // the functional approach uses less memory, but it is slower.
    public static boolean isUnique2(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    // big O(n) object aproach 2.0
    // using boolean array to keep track of the chars in the string.
    // if the char is not in the array, then add it to the array.
    // if the char is in the array, then return false.
    // if the loop completes without returning false, then return true.
    // this approach is faster than the object approach, but it uses more memory.
    // the object approach uses less memory, but it is slower.
    // the boolean array approach uses less memory, but it is slower.
    // the boolean array approach uses less memory, but it is slower.
    // the boolean array approach uses less memory, but it is slower.
    public static boolean isUnique3(String s) {
        if (s == null || s.length() == 0)
            return false;
        boolean[] all_chart_set = new boolean[256];
        for (char theChart : s.toCharArray()) {
            if (!all_chart_set[theChart]) {
                all_chart_set[theChart] = true;
            } else {
                return false;
            }
        }
        return true;
    }

}
