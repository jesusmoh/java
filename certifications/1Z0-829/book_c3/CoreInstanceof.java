public class CoreInstanceof {
    public final static void main(String... arguments) {

        //PatternMatching for subtypes in Java 16
        Number v = 45;
        if (v instanceof Integer data && data > 6)
            System.out.println(data);
        System.out.println(2);

        //PatternMatching is only for subtypes of data in Java 16
        Integer vv = 45;
        if (vv instanceof Integer data && data > 6)// doesn't compiles same type
            System.out.println(data);
        System.out.println(2);

        Number v2v = 45;
        if (v2v instanceof List data) // does compiles with != type for interfaces
        {
            System.out.println(" ok limitations with interfaces " + data);
        } else// does compiles with != type for interfaces
        {
            System.out.println("bad limitations with interfaces ");//data doesn't has scope here
        } //does compiles with != type for interfaces
    }
}
