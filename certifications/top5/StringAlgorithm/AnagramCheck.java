import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AnagramCheck {
    public static void main(String[] args) {

        // the main difence betewn anagram(letters) and permutaion(any obj)
        // anagram is a word formed(means something) by rearranging the letters of
        // another word.

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("listten", "sillent"));

    }

    public static boolean isAnagram(String s, String t) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matchers = pattern.matcher(s);
        Matcher matchert = pattern.matcher(t);
        if (s == null || t == null || matchers.find() || matchert.find() || s.length() != t.length())
            return false;

        var t1 = s.chars().mapToObj(x -> (char) x).sorted().collect(Collectors.toList());
        var t2 = t.chars().mapToObj(x -> (char) x).sorted().collect(Collectors.toList());

        return t1.equals(t2);

    }

}
