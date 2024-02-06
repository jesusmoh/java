public class MutuablesAnaInMutuablesCases {

  public static void main(String[] args) {
    // In Java, everything object is mutable by default(except for strings=).
    // In Java, everything primitive is immutable.
    // Inmutablity depens on the CONTEX

    // Primitive data types are immutable and are not objects

    // Example 1 inmutability
    String str1 = "Hello";
    String str2 = str1; // Creating a new reference to the same object
    // Currently there are 2 references to the same object in the stack poolstring

    str1 = str1 + " World"; // by concatenation, this is a new string and currentrly we have two string
    // str2-->"Hello" and str1-->"Hello World"

    // the original string didn't change only was updated the link from
    // str1-->"Hello" to str1-->"Hello World". THAT IS INMUTABLE VALUE

    System.out.println(str1); // Output: Hello World
    System.out.println(str2); // Output: Hello

    // Example 2 inmutability. That apply to Wrapper
    int n1 = 1;
    int n2 = n1;
    n1 = n1 + 3;
    System.out.println(n1); // n1 has a new referent to new value.
    System.out.println(n2); // n2 has value 1 because the value doesn't change INMUTABLE.

    // Exmaple 3 Mutuable
    StringBuilder a = new StringBuilder("abc");
    StringBuilder b = a.append("de");
    // Difernet reference linked to th same object
    b = b.append("f").append("g");
    a.append("k");
    System.out.println(a);
    System.out.println(b);

    // Exmaple 4 Mutuable
    // Primitive data types are mutable by deafult inside off objects(FINAL)
    class Casa {

      int l;
      int h;
    }

    Casa c1 = new Casa();
    Casa c2 = c1;

    // Difernet reference linked to th same object
    c1.h = 20;
    c1.l = 30;
    c2.h = -1;
    System.out.println(c1.hashCode());
    System.out.println(c2.hashCode());

    // Exmaple 5 Mutuable
    class Auto {

      String l;
      String h;
    }

    Auto c12 = new Auto();
    Auto c22 = c12;

    // Difernet reference linked to th same object
    c12.h = "20";
    c12.l = "30";
    c22.h = "-1";
    System.out.println(c12.h);
    System.out.println(c22.h);
  }
}
