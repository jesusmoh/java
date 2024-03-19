package c1_arrays_and_strings;

public class PalindromePermutation {

    public static void main(String[] args) {
        var t = "fdarra";
        System.out.println(isPalindromePermutation(t));

    }

    public static boolean isPalindromePermutation(String str) {

        if (str == null || str.length() == 0)
            return false;

        // Remove white spaces and convert to lowercase
        str = str.replaceAll("\\s", "").toLowerCase();

        // Create a frequency array to count characters
        int[] charCount = new int[128]; // Assuming ASCII characters

        // Count the frequency of each character
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }

        // Check if there is at most one character with an odd count
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

}
