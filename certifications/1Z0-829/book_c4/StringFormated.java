public class StringFormated {
    public static void main(String[] args) {
        var name = "james";
        var score = 90.25f;
        var total = 100;

        var r = " %s Score : %f out of %d".formatted(name, score, total);

        System.out.println(r);

    }
}
