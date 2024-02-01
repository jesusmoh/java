public class IntOperators {

  public static void main(String[] args) {
    byte b = 4________2; // +/- 128
    short s = 5__0; // +/- 32K
    char y = 'y'; // +65K or 'x'
    char binaryInt = 0B10100; // Binary
    System.out.println((int) binaryInt);//
    char c = (char) (b + s + 1__5 + y + binaryInt); // sum 4 type of data, all operations are sobre int
    System.out.println(c);// letter ø
    System.out.println((int) c);// letter ø # 248
  }
}
