
public class Test {
  public final static void main(String... arguments) {

    String one, two;
    one = new String("A");
    two = new String("B");
    one = two; // in this line the objetc is elegible for GC
    String three = one;
    one = null;

  }

}
