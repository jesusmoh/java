
public class PromotedValues {
  public final static void main(String... arguments) {

    byte b = 4;
    short s = 8;

    Object f = 4 + 8; // All operation will be promoted to int, Object can be int,long,double. NO can
                      // be short or byte whitout cast
    System.out.println(f);

    short s1 = 8;
    short s2 = 8;

    // short s3 = s1 + s2; error because all operation level up to int (short,
    // chart,byte)
    short s3 = (short) (s1 + s2);

  }

}
