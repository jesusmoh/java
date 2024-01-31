public class CoreSwitch {

  public static void main(String[] args) {

    // OLD WAY
    // Suport fot primitives and wrappers( exep : float,long, boolean,double)

    int old = 2;
    final int num3 = 3;

    switch (old) {
      case 1:
        System.out.println(old);
        break;
      case 2:
        System.out.println(old);
      case num3, 4:
        System.out.println(old);
        break;
      default:
        System.out.println(old);
    }

    int n = 2;
    int r = switch (n) {
      case 1 -> {
        System.out.println(n + "?1");
        yield 2 * n;
      }
      case 2 -> {
        System.out.println(n + "?2");
        yield 2 * n;
      }
      case 3 -> 2 * n;
      default -> {
        System.out.println(n + "?d");
        yield 2 * 0;
      }
    };

  }
}
