package c1_arrays_and_strings;

import java.util.stream.Collectors;

public class Case3URLify {
    public static void main(String[] args) {
        String s = "Mr John Smith and Mr Jorge";
        System.out.println(replaceAllBlankSpaces(s));
        System.out.println(replaceAllBlankSpaces2(s));
    }

    static String replaceAllBlankSpaces(String s) {

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

    static String replaceAllBlankSpaces2(String s) {
        if (s != null && s.length() > 0 && !s.contains(" "))
            return "";
        return s.chars().mapToObj(c -> (char) c).map(c -> c == ' ' ? "%20" : String.valueOf(c))
                .collect(Collectors.joining());
    }
}
