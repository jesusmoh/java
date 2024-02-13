package book_c6;

public class ImmutubalesClass {

}

// final in class can't permit to inheritance
final class Cat {
    private int weight;
}

class BlackCat extends Cat {
}

// private all the contrustors
final class Dog {
    private int weight;

    private Dog() {
    };// .....
}

// don't define get and sets, don't expose mutuable objets
final class Bird {
    private int weight;
}
