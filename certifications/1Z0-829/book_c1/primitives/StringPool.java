public class StringPool {

  public static void main(String[] args) {
    String a = "a";
    String b = "a";
    String c = a;

    // Primitive variables store the actual values, whereas Non-Primitives store the reference
    //variables which point to the addresses of the objects they’re referring to.
    // Both values and references are stored in the stack memory
    if (b == a) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }

    String aa = new String(a);
    if (b == aa) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
