
public class Test {
  public final static void main(String... arguments) {

    String a, b, c;
    a = "a";
    b = "b";
    c = a;
    b = c;
    a = c;
    c="h";

    System.out.println("?" + a);
     System.out.println("?" + c);
  }

}
