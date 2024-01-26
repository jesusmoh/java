
public class MyFavoriteNumber {
  public final static void main(String... arguments) {
    int mfn = 20;
    int b = ~mfn; // the same number but +1 and - exma -21
    int p = -mfn;
    var superman = b == p ? 5 : 10;
    System.out.println(b + "," + p + "," + (--superman));
  }

}
