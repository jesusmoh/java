package c1_arrays_and_strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Case1IsUnique {
    public static void main(String[] args) {

        var sentence = "murcielaago";
        System.out.println(hasUniqueChars(sentence));
        System.out.println(hasUniqueChars2(sentence));
        System.out.println(hasUniqueChars3(sentence));
    }

    // beterr big O(n^2)
    static boolean hasUniqueChars(String s) {
        if (s != null) {
            char t = ' ';
            for (int i = 0; i < s.length(); i++) {
                t = s.charAt(i);
                if (s.indexOf(t, i + 1) != -1) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    // big O(n) object aproach
    public static boolean hasUniqueChars2(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    // big O(n) funtional aproach
    public static boolean hasUniqueChars3(String str) {
        if (str == null || str.length() == 0)
            return false;
        var t = str.chars().boxed().distinct().collect(Collectors.toList());
        if (t.size() != str.length())
            return false;
        return true;
    }

}
