
public class App {
 
    public final static void main(String[] args) {
       
        var fop=4;
        float _123=0.0f;
        float _as123=0.0f;
        float pesos123=0.0f;
        float $pesos123=0.0f;

        byte b = 50;
        byte g = 10;
        byte c = Byte.valueOf((byte) (b + g));
        System.out.println("It's important to note that when you add two bytes in Java, the result is an integer " + c);

        float f = 3.14F;
        double d = 3.14;
        double r = f + d;
        System.out.println("If you mix float and double operands in an arithmetic operation, the float operand will be promoted to a double" + r);

        short myShort = 345;
        char myChar = 'A';

        int rs = myShort + (short) myChar;
        int rc = (char) myShort + myChar;
        System.out.println(rs
                + " If you mix short and char operands in an arithmetic operation, the short operand will be promoted to an int before the operation is performed "
                + rc);

        long max =3123456789L;
        // long max1 =3123456789;
        //float myFloat = 1_000_000.16F;
        System.out.println("L is mandatory for long because managed the numebr likes a int");


         double myDouble = 1_000_000.56d;
         double myDouble2 = 1________0.56d;
          System.out.println("Underscores are allowed in all literal types, including byte, int, long, float, and double");

          String pyramid = """ 

aaaa\"
bbbb\"\"\"
""
cc\sc    
""";
        System.out.println("*"+pyramid+"*" +"The text block starts with ");

       
 

    }
}
