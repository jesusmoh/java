public class MainBStaticModificator {

  public static void main(String[] args) {
    class P {

      String a;
      static String mirrora;

      @Override
      public String toString() {
        return this.mirrora;
      }
    }
    P p1 = new P();
    p1.a = "a";
    p1.mirrora = "a";
    P p2 = new P();

    p2.a = "b";
    p2.mirrora = "b";
    System.err.println(p1.toString() + "/" + p2.toString());
  }
}
