package book_c7.encapsulation;

public class ExampleRecord {
    private int i;
    private int t;

    public record Example(int i, int t) {
    }

    public static void main(String[] args) {
        var t = new Example(0, 0);
        System.out.println(t.toString());
    }
}
