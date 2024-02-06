import java.util.Arrays;

public class JavaArrays {

  public static void main(String[] args) {
    //Very import class Arrays.x

    int[] numbers = { 6, 9, 1 };
    Arrays.sort(numbers);
    Arrays.toString(numbers);

    String[][] rectangle = new String[3][2];

    rectangle[0][1] = "set";
    //   |0|     |1|   |2|
    //  |0|SET| |0|1| |0|1|

  }
}
