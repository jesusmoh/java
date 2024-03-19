package c1_arrays_and_strings;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.println(isRotation(s1, s2));
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String s1s1 = s1 + s1;
        return s1s1.contains(s2); // O(n) time, O(1) space.
        // The contains method is O(n) time, and O(1) space.
        // The + operator is O(n) time, and O(1) space.
        // The contains method is O(n) time, and O(1) space.
        // The contains method is O(n) time, and O(1) space.
    }

}
