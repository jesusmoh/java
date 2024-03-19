package c1_arrays_and_strings;

public class StringCompresion {
    public static void main(String[] args) {
        var r = "aaccccaaa";
        var e = "012345678";
        System.out.println(stringCompresion(r));
    }

    public static String stringCompresion(String str) {
        if (str == null || str.length() == 0)
            return "";
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i)).append(count);
                count = 1;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;

    }

}
