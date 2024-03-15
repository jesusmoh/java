package c1_arrays_and_strings;

import java.util.Arrays;

public class Case4PalindromePermutation {
    public static void main(String[] args) {

        var t = "Tact Coa";
        isPalindromePermutation(t);
        System.out.println(isPalindromePermutation2(t));
    }

    static public boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0)
            return false;

        var f = s.toLowerCase();
        var a = new StringBuffer();
        var b = new StringBuffer();
        var c = new StringBuffer();
        var t = f.toCharArray();
        Arrays.sort(t);
        for (int i = 0; i < t.length; i++) {
            if (t[i] == t[i + 1]) {
                a.append(t[i]);
                b.append(t[i]);
                i++;
            } else {
                c.append(t[i]);
            }
        }

        if (a.length() + c.length() + b.length() == f.length())
            return true;
        return false;
    }

    public static boolean isPalindromePermutation2(String str) {
        // Remove spaces and convert to lowercase
        str = str.toLowerCase();

        int[] charCount = new int[128]; // Assuming ASCII characters

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        int oddCount = 0;

        // Check if there is at most one character with odd count
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }

        return true;
    }
}
