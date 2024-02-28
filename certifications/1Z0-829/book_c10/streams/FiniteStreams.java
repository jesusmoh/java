import java.util.stream.Stream;

public class FiniteStreams {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();
        Stream<String> singleElement = Stream.of("1");
        Stream<String> fromArray = Stream.of("!", "4", "t");
    }
}
