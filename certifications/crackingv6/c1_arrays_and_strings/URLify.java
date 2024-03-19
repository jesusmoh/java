package c1_arrays_and_strings;

import java.util.stream.Collectors;

public class URLify {
    public static void main(String[] args) {

        var s = "Mr John Smith    ";
        var n = 13;
        System.out.println(urlLify(s, n));
        System.out.println(urlLify2(s, n));
    }

    // funtional aproachh 2.0
    private static String urlLify(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0)
            return null;
        return s.chars().limit(n).mapToObj(c -> (char) c).reduce("", (a, b) -> b == ' ' ? a + "%20" : a + b,
                String::concat);
    }

    // funtional aproachh 2.0
    private static String urlLify2(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0)
            return null;
        return s.chars().limit(n).mapToObj(c -> (char) c).map(c -> c == ' ' ? "%20" : String.valueOf(c))
                .collect(Collectors.joining());
    }

    // normal approach
    static String urlLify3(String s) {

        if (s != null && s.length() > 0 && !s.contains(" "))
            return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
