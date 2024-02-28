package book_c10.streams;

import java.util.stream.Stream;

public class InfiniteStreams {

    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(Math::random);// this line only define

        randoms.forEach(x -> System.out.println("x"));// this line is the inifite

    }
}
