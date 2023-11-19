public class KitchenSink {
    private int numForks;

    public static void main(String[] args) {

        // var a=2, b=2; var does not suport multi assigment
        int numKnives;
        long var = 8L;// ins't a reserved word
        System.out.print("""
                "# forks = " + numForks +
                " # knives = " +numKnives +
                # cups=0 """);

        KitchenSink n = new KitchenSink();
        Test t = new Test();
        int aa = 0xE;
        int bb = 0b101;
        System.out.print(">>" + var);
        System.out.print(">>" + aa + " AND " + bb);
    }

    // trick with text block simulate strin and concatenation in stirng
}