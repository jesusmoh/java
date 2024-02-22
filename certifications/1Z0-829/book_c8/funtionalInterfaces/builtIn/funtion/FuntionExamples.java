package book_c8.funtionalInterfaces.builtIn.funtion;

import java.util.function.Function;

public class FunctionExamples {
    public static void main(String[] args) {
        Function<String, Integer> wordLengthFunction = (str) -> {
            String[] words = str.split(" ");
            int totalLength = 0;
            for (String word : words) {
                totalLength += word.length();
            }
            return totalLength;
        };

        String sentence = "This is a sample sentence";
        int totalLength = wordLengthFunction.apply(sentence);
        System.out.println("Total length of words in the sentence: " + totalLength);
    }
}
