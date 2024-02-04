public class JavaStrings {

  public static void main(String[] args) {
    // each iteration creates a new string in HEAD PARTITION (pool string)(inmutuable)
    String alpha = "";
    for (char current = 'a'; current < 'z'; current++) {
      alpha += current;
    }
    System.err.println(alpha);

    // each iteration creates a new string in HEAD PARTITION (common objt area)(inmutuable)
    String alpha2 = "";
    for (char current = 'a'; current < 'z'; current++) {
      alpha2 = new String(alpha2 + current);
    }
    System.err.println(alpha2);

    // each iteration creates is over the same string in HEAD PARTITION (common objt area)(mutuable)
    StringBuilder alpha4 = new StringBuilder();
    for (char current = 'a'; current < 'z'; current++) {
      alpha4.append(current);
    }
    System.err.println(alpha4);

    var name = "a";
    var builder = new StringBuilder("a");
    System.out.println(name == builder.toString());
    System.out.println(name.equals(builder.toString()));

    //String objects can not use == exep when is the same objetc(reference)
    var e1 = new String("A");
    var e2 = new String("A");
    var e3 = e2.trim();
    System.out.println(e1 == e2); //false
    System.out.println(e3 == e2); //true

    //String in poolstring can uses ==, but only works for literales and const eventhuog
    var e22 = "A";
    var e33 = "A";
    var e44 = "A ".trim();
    System.out.println(e22 == e33); //true
    System.out.println("Are e33 and e44 = ?-" + e33 + "-" + e44 + "-");
    System.out.println(e22 == e44.trim()); //true

    //final test
    var first = "rat" + 1;
    var second = "r" + "a" + "t" + "1";
    var third = "r" + "a" + "t" + new String("1");
    System.out.println(first == second); //true both are literales
    System.out.println(first == second.intern()); //true both are literales and here i enforced the poolstring
    System.out.println(first == third); // false because objetc + literal= objetc
  }
}
