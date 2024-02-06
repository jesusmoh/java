public class PassinObjC {

  public static void main(String[] args) {
    class A {

      String a;

      public void speak(String a) {
        a = "a";
        System.err.println(a);
      }
    }
    String z = "z";

    A a1 = new A();

    //methods never change the original value, java by default uses pass by value.
    //For primitives the method uses a reference.(INMUTUBALE)
    //For a common object, method uses a clone.
    a1.speak(z);
    System.err.println(z);
    System.err.println(a1.a);
  }
}
