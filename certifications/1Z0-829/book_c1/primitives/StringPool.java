public class StringPool {
  public static void main(String[] args) {
    String a = "a";
    String b = "a";
    String c = a;

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
