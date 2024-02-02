public class TernaryOperations {
  public static void main(String[] args) {
    int x = 10;
    int y = 5;
    int z = 20;

    // Using nested ternary operator to find the largest number among three numbers
    int largest = (x > y) ? ((x > z) ? x : z) : ((y > z) ? y : z);

    System.out.println("The largest number is: " + largest);
  }
}
