public class PassinObj {

  public static void main(String[] args) {
    String name = "Webby";
    speak(name);
    System.err.println(name);

    class P {

      String a;

      public void speak(String a) {
        a = "P";
        System.err.println(a);
      }
    }

    String z = "z";
    P p1 = new P();
    p1.speak(z);
    System.err.println(z);
  }

  public static void speak(String a) {
    a = "ppp";
    System.err.println(a);
  }
}
