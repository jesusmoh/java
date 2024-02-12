package book_c6;

public class ClassBehabiorCharching {
    private String name = "BestZoo"; // 3 fields in order too
    {
        System.out.print(name + "-");
    }
    private static int COUNT = 0;
    static {
        System.out.println(COUNT + "-");// 1 are all static values in order
    }
    static {
        COUNT += 10;
        System.out.println(COUNT + "-");// 2
    }

    public ClassBehabiorCharching() { // 4 the last the constructor
        System.out.println("z-");
    }

    public static void main(String[] args) {
        new ClassBehabiorCharching();

    }// 0-10-BestZoo-z-
}
